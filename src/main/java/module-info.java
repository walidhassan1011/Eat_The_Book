module com.example.eatthebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.example.eatthebook to javafx.fxml;
    opens EatTheBook.Models to javafx.fxml;
    opens EatTheBook to javafx.fxml;
    exports com.example.eatthebook;
    exports EatTheBook.Models;
    exports EatTheBook;
    exports EatTheBook.Controllers;
    opens EatTheBook.Controllers to javafx.fxml;
}