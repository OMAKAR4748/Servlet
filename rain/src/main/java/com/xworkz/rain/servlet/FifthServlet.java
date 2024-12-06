package com.xworkz.rain.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/fifth", loadOnStartup = 1)
public class FifthServlet extends HttpServlet {

    public FifthServlet()
    {

        System.out.println("running no-args const of firstServlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Executing service in FirstServlet");
        String url = req.getRequestURI().toString();
        System.out.println("URL :" +url);
        Enumeration<String> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements())
        {
            String headerName = enumeration.nextElement();
            String value = req.getHeader(headerName);
            System.out.println(headerName +" :"+value);
        }

        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Mango is working......");
    }
}

