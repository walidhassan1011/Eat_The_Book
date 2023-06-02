package EatTheBook.Controllers;

import EatTheBook.DB.DB_EatTheBook_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.Navigator;
import EatTheBook.Models.EatTheBook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextField AddressField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField PhoneField;

    @FXML
    private Button createBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button minimizeBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button returnBtn;
    @FXML
    void createAccountfunc(ActionEvent event) {
        if (nameField.getText().isEmpty() || passwordField.getText().isEmpty() || EmailField.getText().isEmpty() || PhoneField.getText().isEmpty() || AddressField.getText().isEmpty()){
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "error");
            return;
        }
        if (nameField.getText().length() < 3 || passwordField.getText().length() < 3 ){
            AlertHandlerError.showAlert("Error", "Username and password must be at least 3 characters", "Error");
            return;
        }
            EatTheBook.register(nameField.getText(), passwordField.getText(), EmailField.getText(), PhoneField.getText(), AddressField.getText(), "Student");
        // close the current window
        Scene scene = createBtn.getScene();
        scene.getWindow().hide();


    }

    @FXML
    void returnFunc(ActionEvent event) {
       try
       {

           Navigator.NavigateTo( "login.fxml", "Login",691, 469);
           // close the current window
           Scene scene = returnBtn.getScene();
           scene.getWindow().hide();
       }catch (Exception e){
           AlertHandlerError.showAlert("Error", "Something went wrong", "error");
       }

    }
    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void minimize(ActionEvent event) {
        Stage stage = (Stage) minimizeBtn.getScene().getWindow();
        stage.setIconified(true);
    }

}
