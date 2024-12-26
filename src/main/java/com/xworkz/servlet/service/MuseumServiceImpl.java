package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MuseumTicketFormDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MuseumServiceImpl implements MuseumService{
    @Override
    public boolean save(MuseumTicketFormDto museumTicketFormDto) {

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

            String insert = "insert into MuseumTicketForm values(0,'"+museumTicketFormDto.getCustomerName()+"',"+museumTicketFormDto.getAdultMembers()+","+museumTicketFormDto.getChildMembers()+",'"+museumTicketFormDto.getMobileNo()+"','"+museumTicketFormDto.getEmail()+"')";

            statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("no of rows inserted :" + row);

        } catch (ClassNotFoundException | SQLException c) {
            System.out.println("jdbc class not found" + c.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                save(museumTicketFormDto);
            }
        }
        return true;
    }
}
