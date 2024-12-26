package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MilkFormDto;
import com.xworkz.servlet.repository.MilkRepository;
import com.xworkz.servlet.repository.MilkRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MilkServiceImpl implements MilkService{
     private MilkRepository milkRepository = new MilkRepositoryImpl();


    @Override
    public boolean save(MilkFormDto milkFormDto) {
        System.out.println("saved");
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

            String insert = "insert into CricketTournament values(0,'"+milkFormDto.getBrand()+"',"+milkFormDto.getType()+","+milkFormDto.getQuantity()+","+milkFormDto.getTotalPrice()+")";

            statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("no of rows inserted :" + row);

        } catch (ClassNotFoundException | SQLException c) {
            System.out.println("jdbc class not found" + c.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                save(milkFormDto);
            }
        }
        boolean result = milkRepository.save(milkFormDto);
        return result;
    }
}
