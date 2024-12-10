package com.xworkz.ornament.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Submit",loadOnStartup = 1)
public class OrnamentServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("name");
        String grams =req.getParameter("grams");
        String gramPerCost =req.getParameter("gramPerCost");
        String gst =req.getParameter("gst");
        String serviceRate =req.getParameter("serviceRate");

        RequestDispatcher requestDispatcher=
                req.getRequestDispatcher("OrnamentResult.jsp");
        req.setAttribute("name",name);
        req.setAttribute("grams",grams);
        req.setAttribute("gramPerCost",gramPerCost);
        req.setAttribute("gst",gst);
        req.setAttribute("serviceRate",serviceRate);
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {

    }
}
