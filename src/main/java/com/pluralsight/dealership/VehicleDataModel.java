package com.pluralsight.dealership;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VehicleDataModel {
    private Connection connection;
    private Scanner scanner;

    public VehicleDataModel(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void getByPriceRange() {
        String query = "{CALL getByPriceRange(?)}";
        try {
            System.out.println("Enter the maximum amount to filter by");
            Double maxAmount = scanner.nextDouble();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setDouble(1,maxAmount);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that are in that range");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        //show the vehicles that come back from the rs change below
                        //id VIn COLOR MAKE SOLD PRICE
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
e.printStackTrace();
        }

    }
}
