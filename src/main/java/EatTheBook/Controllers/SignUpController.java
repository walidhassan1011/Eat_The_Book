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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.bcrypt.BCrypt;

public class SignUpController {

    @FXML
    private TextField AddressField;

    @FXML
    private TextField EmailField;

    @FXML
    private RadioButton Female_Radio;

    @FXML
    private RadioButton Male_Radio;

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
    private PasswordField passwordfield;

    @FXML
    private Button returnBtn;
    @FXML
    void createAccountfunc(ActionEvent event) {
        if (nameField.getText().isEmpty() || passwordfield.getText().isEmpty() || EmailField.getText().isEmpty() || PhoneField.getText().isEmpty() || AddressField.getText().isEmpty()){
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "error");
            return;
        }
        // check email
        if (!EmailField.getText().contains("@") || !EmailField.getText().contains(".")){
            AlertHandlerError.showAlert("Error", "Please enter a valid email", "error");
            return;
        }
        // check phone
        if (PhoneField.getText().length() != 11){
            AlertHandlerError.showAlert("Error", "Please enter a valid phone number", "error");
            return;
        }

        if (nameField.getText().length() < 3 || passwordfield.getText().length() < 8 ){
            AlertHandlerError.showAlert("Error", "Username and password must be at least 3 characters", "Error");
            return;
        }

            EatTheBook.register(nameField.getText(),passwordfield.getText() , EmailField.getText(), PhoneField.getText(), AddressField.getText(), "Admin");
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
