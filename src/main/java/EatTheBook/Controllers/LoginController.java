package EatTheBook.Controllers;

import EatTheBook.DB.DB_EatTheBook_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.Navigator;
import EatTheBook.Models.EatTheBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button loginBtn1;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    void SignUpFunc(ActionEvent event) throws IOException {

        Navigator.NavigateTo( "signUp.fxml", "Sign Up",691, 469);
        // close the current window
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void loginFunc(ActionEvent event) {
        if (nameField.getText().isEmpty() || passwordField.getText().isEmpty()){
             AlertHandlerError.showAlert("Error", "Please fill all the fields", "error");
            return;
        }
        EatTheBook.login(nameField.getText(), passwordField.getText());
        // close the current window
        Scene scene = loginBtn.getScene();
        scene.getWindow().hide();


    }

    @FXML
    void minimize(ActionEvent event) {

        Stage stage = (Stage) minimizeBtn.getScene().getWindow();
        stage.setIconified(true);

    }

}
