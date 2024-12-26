package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.CricketTournamentDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CricketTournamentRepositoryImpl implements CricketTournamentRepository {

    @Override
    public boolean save(CricketTournamentDto cricketTournamentDto) {
        return true;
    }

    @Override
    public List<CricketTournamentDto> getAllCricketForm() {
        List<CricketTournamentDto> cricketTournaments = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM crickettournament")) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            while (resultSet.next()) {
                String teamName = resultSet.getString("teamName");
                String captainName = resultSet.getString("captainName");
                String contactNumber = resultSet.getString("contactNumber");
                String email = resultSet.getString("email");
                int numPlayers = resultSet.getInt("numPlayers");
                String coachName = resultSet.getString("coachName");
                String homeGround = resultSet.getString("homeGround");
                String sponsorsName = resultSet.getString("sponsorsName");

                CricketTournamentDto cricketTournament = new CricketTournamentDto(teamName, captainName, contactNumber, email, numPlayers, coachName, homeGround, sponsorsName);
                cricketTournaments.add(cricketTournament);

//                System.out.println("Number of cricket tournaments: " + cricketTournaments.size());
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return cricketTournaments;
    }
}
