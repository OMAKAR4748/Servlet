package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MilkFormDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MilkRepositoryImpl implements MilkRepository {

    @Override
    public boolean save(MilkFormDto milkFormDto) {
        return true;
    }

    @Override
    public List<MilkFormDto> getAllMilkForms() {
        List<MilkFormDto> milkForms = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM milkForm")) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String type = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");
                int totalPrice = resultSet.getInt("totalPrice");

                MilkFormDto milkForm = new MilkFormDto(brand, type, quantity, totalPrice);
                milkForms.add(milkForm);

                System.out.println("No of order :"+statement.getFetchSize());
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return milkForms;
    }
}
