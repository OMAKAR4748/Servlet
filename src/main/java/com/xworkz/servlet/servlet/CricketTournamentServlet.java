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
import java.util.List;

@WebServlet(urlPatterns = "/CricketTournamentServlet", loadOnStartup = 1)
public class CricketTournamentServlet extends HttpServlet {

    private CricketService cricketService = new CricketServiceImpl();

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
            req.setAttribute("message ",teamName+  "   "  + captainName +  "   "+ contactNumber + "    "  +email+  "  "+ numPlayers + "   "  + coachName +  "     "+ homeGround + "    "+ sponsorsName);

        }else {
            req.setAttribute("message","not saved");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("CricketTournament.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<CricketTournamentDto> cricketTournaments = cricketService.getAllCricketForm();
        req.setAttribute("cricketTournaments", cricketTournaments);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("CricketResult.jsp");
        requestDispatcher.forward(req, resp); }


}
