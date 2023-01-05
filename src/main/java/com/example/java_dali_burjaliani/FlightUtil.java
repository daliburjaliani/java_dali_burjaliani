package com.example.java_dali_burjaliani;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightUtil {
    FlightUtil() {

    }

    public static int discount(int price){
        return price * 20 / 100;
    }

    private static final String CREATE = "CREATE TABLE IF NOT EXISTS FLIGHTS(" +
            "CITY VARCHAR(30)," +
            "DATE VARCHAR(30)," +
            "SEAT INTEGER," +
            "PRICE INTEGER)";


    public static void createTable() {
        try {
            JDBCConfig.getStatement().executeUpdate(CREATE);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static String insert(Flight flight){

        String INSERT_TABLE = "INSERT INTO FLIGHTS(CITY, DATE, SEAT, PRICE) VALUES(" +
                "'"+ flight.getCity() + " ', '" +
                flight.getDate() + "'," +
                flight.getSeats() + ","
                + flight.getPrice() + ")";

        try {
            JDBCConfig.getStatement().executeUpdate(INSERT_TABLE);
            return "Item inserted successfully";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<PieChart.Data> chart(){

        String SELECT = "SELECT CITY, COUNT(*) AS COUNT FROM FLIGHTS GROUP BY CITY";

        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();

        try{
            ResultSet result = JDBCConfig.getStatement().executeQuery(SELECT);

            while (result.next()){
                observableList.add(new PieChart.Data(result.getString("CITY"), result.getInt("COUNT")));
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return observableList;

    }

}
