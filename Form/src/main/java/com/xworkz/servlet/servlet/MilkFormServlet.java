package com.xworkz.servlet.servlet;

import com.xworkz.servlet.dto.MilkFormDto;
import com.xworkz.servlet.service.MilkService;
import com.xworkz.servlet.service.MilkServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/MilkFormServlet", loadOnStartup = 1)
public class MilkFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String type = req.getParameter("type");
        String quantity= req.getParameter("quantity");

        Map<String, Integer> map = new HashMap<>();
        map.put("Special", 56);
        map.put("Ordinary", 54);
        map.put("Good Life", 67);
        map.put("Good Life Lite", 68);
        map.put("Family", 56);
        map.put("Buffalo", 70);

        int pricePerUnit = map.get(type);
        int totalQuantity = Integer.parseInt(quantity);

        int totalPrice = totalQuantity * pricePerUnit;

        MilkFormDto milkForm = new MilkFormDto(brand,type,totalQuantity,totalPrice);
        req.setAttribute("milkForm",milkForm);

        MilkService milkService = new MilkServiceImpl();

        boolean result =milkService.save(milkForm);
        if (result ==true)
        {
            req.setAttribute("message",brand+ " the Cost for " + type + " milk is : "+ totalPrice);

        }else {
            req.setAttribute("message","not saved");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("MilkForm.jsp");
        requestDispatcher.forward(req, resp);



        System.out.println("Successfully Register...");

    }
}
