package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MuseumTicketFormDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MuseumRepositoryImpl implements MuseumRepository {

    @Override
    public boolean save(MuseumTicketFormDto museumTicketFormDto) {
        return true;
    }

    @Override
    public List<MuseumTicketFormDto> getAllMusemTicketForm() {
        List<MuseumTicketFormDto> museumTickets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM MuseumTickets")) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            while (resultSet.next()) {
                String customerName = resultSet.getString("customerName");
                int adultMembers = resultSet.getInt("adultMembers");
                int childMembers = resultSet.getInt("childMembers");
                String mobileNo = resultSet.getString("mobileNo");
                String email = resultSet.getString("email");

                MuseumTicketFormDto museumTicket = new MuseumTicketFormDto(customerName, adultMembers, childMembers, mobileNo, email);
                museumTickets.add(museumTicket);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return museumTickets;
    }
}
