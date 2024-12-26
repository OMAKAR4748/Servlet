package com.xworkz.servlet.servlet;

import com.xworkz.servlet.dto.SweetFormDto;
import com.xworkz.servlet.service.SweetService;
import com.xworkz.servlet.service.SweetServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/SweetFormServlet", loadOnStartup = 1)
public class SweetFormServlet extends HttpServlet {

    private SweetService sweetService = new SweetServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shopName = req.getParameter("shopName");
        String sweetName = req.getParameter("sweetName");
        String special = req.getParameter("special");
        String quantityParam = req.getParameter("quantity");
        String weightParam = req.getParameter("weight");

        Map<String, Integer> sweetPrices = new HashMap<>();
        sweetPrices.put("Kaju katli", 300);
        sweetPrices.put("Barfi", 300);
        sweetPrices.put("Gulab Jamun", 300);
        sweetPrices.put("Rasgulla", 300);
        sweetPrices.put("Soan Papdi", 300);
        sweetPrices.put("Rasmalai", 300);
        sweetPrices.put("Modak", 300);
        sweetPrices.put("Boondi", 300);
        sweetPrices.put("Jeelebi", 300);
        sweetPrices.put("Shrikhand", 300);
        sweetPrices.put("Kalakand", 300);

        int pricePerKg = sweetPrices.get(sweetName);
        double weight = Double.parseDouble(weightParam);
        int quantity = Integer.parseInt(quantityParam);



        double sweetPrice = pricePerKg * weight * quantity;

        if (special != null) {
            sweetPrice += 30;
        }

        boolean success = true;

        SweetFormDto sweetForm = new SweetFormDto(shopName, sweetName, weight, quantity, sweetPrice);
        req.setAttribute("sweetForm", sweetForm);

        SweetService sweetService =new SweetServiceImpl();
        boolean result =sweetService.save(sweetForm);
        if (result ==true)
        {
            req.setAttribute("message",shopName+" " + sweetName + " "+weight +" "+quantity+":" +sweetPrice);

        }else {
            req.setAttribute("message","not saved");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("SweetForm.jsp");
        dispatcher.forward(req, resp);
        if (success) {
            req.setAttribute("status", "success");
        } else {
            req.setAttribute("status", "failure");
        }

        System.out.println(success ? "Successfully Registered..." : "Registration Failed...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<SweetFormDto> sweetForms = sweetService.getAllSweetForms();
        req.setAttribute("sweetForms", sweetForms);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SweetResult.jsp");
        requestDispatcher.forward(req, resp);
    }
}
