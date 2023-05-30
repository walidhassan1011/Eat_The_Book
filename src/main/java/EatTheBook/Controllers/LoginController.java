package EatTheBook.Controllers;

import EatTheBook.Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button loginBtn;
    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;
        @FXML
        protected void HelloTest() {
            loginBtn.setText("Welcome to JavaFX Application!");

                System.out.println("user");
        }
    @FXML
    public void minimize() {
            Stage stage = (Stage) minimizeBtn.getScene().getWindow();
            stage.setIconified(true);

    }
        @FXML
        public void exit(){
            System.exit(0);
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
