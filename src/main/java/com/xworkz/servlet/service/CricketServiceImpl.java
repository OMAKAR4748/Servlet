package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.CricketTournamentDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CricketServiceImpl implements CricketService{


    @Override
    public boolean save(CricketTournamentDto cricketTournamentDto) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection successful");
            String url = "jdbc:mysql://localhost:3306/xworkz";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(" jdbc connected succesfully");

            String insert = "insert into CricketTournament values(0,'"+cricketTournamentDto.getTeamName()+"','"+cricketTournamentDto.getCaptainName()+"',"+cricketTournamentDto.getContactNumber()+",'"+cricketTournamentDto.getEmail()+"',"+cricketTournamentDto.getNumPlayers()+",'"+cricketTournamentDto.getCoachName()+"','"+cricketTournamentDto.getHomeGround()+"','"+cricketTournamentDto.getSponsorsName()+"')";

            statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("no of rows inserted :" + row);

        } catch (ClassNotFoundException | SQLException c) {
            System.out.println("jdbc class not found" + c.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                save(cricketTournamentDto);
            }
        }
        return true;
    }
}
