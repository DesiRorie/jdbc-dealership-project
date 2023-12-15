package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String myPassword = System.getenv("MY_DB_PASSWORD");

        //Creating the datasource to be used throughout the app.
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/CarDealershipDatabase");
        dataSource.setUsername(user);
        dataSource.setPassword(myPassword);
        Connection conn = dataSource.getConnection();

        DealershipDataModel dealershipDataModel = new DealershipDataModel(conn);
        VehicleDataModel vehicleDataModel = new VehicleDataModel(conn,scanner);
////        vehicleDataModel.getByPriceRange();
//        UserInterface uI = new UserInterface();
//vehicleDataModel.getByYearRange();

//vehicleDataModel.getByMileageRange()
;
vehicleDataModel.getByCarType();


//        uI.display();
    }
}






