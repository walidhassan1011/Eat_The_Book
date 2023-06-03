package EatTheBook.Models;

import EatTheBook.DB.DB_Order_Controller;
import EatTheBook.DB.DB_Users_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.IUser;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class User implements IUser {

    private ObjectId _id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String image;
    private String role;





    public User(String username, String password, String email, String phone, String address,String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this._id = new ObjectId();
    }


public void set_id(ObjectId _id) {
        this._id = _id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {

    }



    public String getUsername() {
        return username;
    }

    public ObjectId get_id() {
        return _id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
public String getRole() {
        return role;}


    @Override
    public void makeOrder(Book book, int quantity, Student student) {

    }

    @Override
    public void deleteOrder(ObjectId id) {
        DB_Order_Controller.deleteOrder(id);
    }
}
