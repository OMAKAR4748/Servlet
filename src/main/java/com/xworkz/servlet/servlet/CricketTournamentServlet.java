package com.xworkz.servlet.servlet;

import com.xworkz.servlet.dto.CricketTournamentDto;
import com.xworkz.servlet.service.CricketService;
import com.xworkz.servlet.service.CricketServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CricketTournamentServlet", loadOnStartup = 1)
public class CricketTournamentServlet extends HttpServlet {
    public CricketTournamentServlet()
    {
        System.out.println("running in CricketTournamentServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teamName = req.getParameter("teamName");
        String captainName = req.getParameter("captainName");
        String contactNumber = req.getParameter("contactNumber");
        String email = req.getParameter("email");
        int numPlayers = Integer.parseInt(req.getParameter("numPlayers"));
        String coachName = req.getParameter("coachName");
        String homeGround = req.getParameter("homeGround");
        String sponsorsName = req.getParameter("sponsorsName");

        CricketTournamentDto tournamentForm = new CricketTournamentDto(teamName, captainName, contactNumber, email, numPlayers, coachName, homeGround, sponsorsName);
        req.setAttribute("tournamentForm", tournamentForm);


        CricketService cricketService = new CricketServiceImpl();
        boolean result =cricketService.save(tournamentForm);
        if (result ==true)
        {
            req.setAttribute("message",teamName+" match led by " + captainName + " they shared the contact number "+ contactNumber + " and "+email+",and number of players is "+ numPlayers + " and this team coach name is "+ coachName + " and home ground "+ homeGround + " and sponsor by "+ sponsorsName);

        }else {
            req.setAttribute("message","not saved");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("CricketTournament.jsp");
        requestDispatcher.forward(req, resp);

    }

}
