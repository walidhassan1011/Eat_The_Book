package EatTheBook.Models;

import EatTheBook.DB.DB_EatTheBook_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import org.bson.types.ObjectId;
import org.mindrot.bcrypt.BCrypt;

import java.security.SecureRandom;

public class EatTheBook {
    private ObjectId _id;
    private String PlaceName;
    private String PlaceAddress;
    private String PlacePhone;
    private String PlaceEmail;
    private String PlaceImage;
    private String PlaceDescription;


    public EatTheBook() {
        this.PlaceName = "EatTheBook";
        this.PlaceAddress = "1 street of EatTheBook";
        this.PlacePhone ="01000000000";
        this.PlaceEmail = "EatTheBook@gmail.com";
        this.PlaceImage = "EatTheBook.jpg";
        this.PlaceDescription = "EatTheBook is a library system that allows you to buy and borrow books.";
        this._id = new ObjectId();
    }

    public static void  register(String username, String password, String email, String phone, String address, String role) {
       try
       {
           DB_EatTheBook_Controller.CreateAccount(new Student(
                   username,
                   password,
                   email,
                   phone,
                   address,
                   role,
                   0.0,
                   0,
                   0,
                   0
           ));
       }
       catch (Exception e)
       {
           AlertHandlerError.showAlert("Error", "Error while creating account", "Please try again");
       }
    }
    public static void login (String username, String password) {
        try {
            DB_EatTheBook_Controller.Login(username, password);
        }catch (Exception e){
            System.out.println(e.getMessage());
            AlertHandlerError.showAlert("Error", "Error while logging in", "Please try again");
        }
    }
}
