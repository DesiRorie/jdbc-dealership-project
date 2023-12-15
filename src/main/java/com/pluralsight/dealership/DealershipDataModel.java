package com.pluralsight.dealership;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DealershipDataModel {
    private Connection connection;

    public DealershipDataModel(Connection connection) {
        this.connection = connection;
    }

}
