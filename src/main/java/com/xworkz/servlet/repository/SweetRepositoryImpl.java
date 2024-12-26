package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.SweetFormDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SweetRepositoryImpl implements SweetRepository {

    @Override
    public boolean save(SweetFormDto sweetFormDto) {
        return true;
    }

    @Override
    public List<SweetFormDto> getAllSweetForms() {
        List<SweetFormDto> sweetForms = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Sweets")) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            while (resultSet.next()) {
                String shopName = resultSet.getString("shopName");
                String sweetName = resultSet.getString("sweetName");
                double weight = resultSet.getDouble("weight");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                SweetFormDto sweetForm = new SweetFormDto(shopName, sweetName, weight, quantity, price);
                sweetForms.add(sweetForm);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return sweetForms;
    }
}
