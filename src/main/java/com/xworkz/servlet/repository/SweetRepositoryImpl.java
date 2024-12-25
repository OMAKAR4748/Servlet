package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.SweetFormDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SweetRepositoryImpl implements SweetRepository{
    @Override
    public boolean save(SweetFormDto sweetFormDto) {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection successful");
            String url = "jdbc:mysql://localhost:3306/xworkz";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(" jdbc connected succesfully");

            String insert = "insert into SweetForm values(0,'"+sweetFormDto.getShopName()+"','"+sweetFormDto.getSweetName()+"',"+sweetFormDto.getWeight()+","+sweetFormDto.getQuantity()+","+sweetFormDto.getPrice()+")";

            Statement statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("no of rows inserted :" + row);

        } catch (ClassNotFoundException | SQLException c) {
            System.out.println("jdbc class not found" + c.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
