module com.example.java_dali_burjaliani {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires org.testng;


    opens com.example.java_dali_burjaliani to javafx.fxml;
    exports com.example.java_dali_burjaliani;
}