package com.xworkz.servlet.servlet;

import com.xworkz.servlet.dto.MuseumTicketFormDto;
import com.xworkz.servlet.service.MuseumService;
import com.xworkz.servlet.service.MuseumServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/MuseumTicketServlet", loadOnStartup = 1)
public class MuseumTicketServlet extends HttpServlet {

    private MuseumService museumService = new MuseumServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("customerName");
        int adultMembers = Integer.parseInt(req.getParameter("adults"));
        int childMembers = Integer.parseInt(req.getParameter("children"));
        String mobileNo = req.getParameter("mobile");
        String email = req.getParameter("email");

        int ADULT_TICKET_PRICE = 100;
        int CHILD_TICKET_PRICE = 50;

        int adultTotal = adultMembers * ADULT_TICKET_PRICE;
        int childTotal = childMembers * CHILD_TICKET_PRICE;
        int totalPrice = adultTotal + childTotal;

        MuseumTicketFormDto ticketForm = new MuseumTicketFormDto(customerName, adultTotal, childTotal , mobileNo, email);
        req.setAttribute("ticketForm", ticketForm);
        req.setAttribute("adultTotal", adultTotal);
        req.setAttribute("childTotal", childTotal);
        req.setAttribute("totalPrice", totalPrice);

        boolean result = museumService.save(ticketForm);
        if (result) {
            req.setAttribute("message", customerName + " and their adults' museum cost is " + adultTotal + " and their children's museum cost is " + childTotal + " mobile number " + mobileNo + " and email id " + email);
        } else {
            req.setAttribute("message", "not saved");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("MuseumTicketForm.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MuseumTicketFormDto> museumTickets = museumService.getAllMusemTicketForm();
        req.setAttribute("museumTickets", museumTickets);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("MuseumResult.jsp");
        requestDispatcher.forward(req, resp);
    }
}
