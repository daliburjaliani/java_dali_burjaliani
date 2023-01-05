package com.example.java_dali_burjaliani;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root= new Group();

        TextField city = new TextField();
        city.setLayoutX(100);
        city.setLayoutY(40);
        city.setPromptText("City");

        TextField date = new TextField();
        date.setLayoutX(100);
        date.setLayoutY(80);
        date.setPromptText("Date");

        TextField seats = new TextField();
        seats.setLayoutX(100);
        seats.setLayoutY(120);
        seats.setPromptText("Seats");

        TextField price = new TextField();
        price.setLayoutX(100);
        price.setLayoutY(160);
        price.setPromptText("Price");

        Button insertButton = new Button("Insert");
        insertButton.setLayoutX(100);
        insertButton.setLayoutY(190);

        Text insertText = new Text();
        insertText.setLayoutX(100);
        insertText.setLayoutY(240);

        Button getChartButton = new Button("Get Chart");
        getChartButton.setLayoutY(40);
        getChartButton.setLayoutX(300);

        root.getChildren().add(city);
        root.getChildren().add(date);
        root.getChildren().add(seats);
        root.getChildren().add(price);
        root.getChildren().add(insertButton);
        root.getChildren().add(insertText);
        root.getChildren().add(getChartButton);

        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FlightUtil.createTable();

                String flightCity = city.getText();
                String flightDate = date.getText();
                int flightSeats = Integer.parseInt(seats.getText());
                int flightPrice = Integer.parseInt(price.getText());

                String result = FlightUtil.insert(new Flight(flightCity, flightDate, flightSeats, flightPrice));
                insertText.setText(result);


                city.clear();
                date.clear();
                seats.clear();
                price.clear();
            }
        });

        getChartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PieChart pieChart = new PieChart();
                pieChart.setData(FlightUtil.chart());
                pieChart.setLayoutX(300);
                pieChart.setLayoutY(20);
                pieChart.setTitle("Flights");
                root.getChildren().add(pieChart);
            }
        });


        Scene scene = new Scene(root, 1000 , 700);
        stage.setTitle("Java App!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}