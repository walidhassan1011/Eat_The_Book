package EatTheBook.DB;

import EatTheBook.Context.ContextApi;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Helpers.Navigator;
import EatTheBook.Models.*;
import com.mongodb.client.MongoCollection;
import javafx.scene.control.Alert;
import org.bson.Document;
import org.bson.json.JsonWriter;
import org.bson.types.ObjectId;
import org.mindrot.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;

public class DB_EatTheBook_Controller {

    /**
     * @desc: this func will return true if the user is in the DB, else will return false
     * @param: name, password
     * @return: boolean
     *
     */

    public static boolean checkUser(String studentNo){

       try {
           MongoCollection collection = DB_helpers.getCollection("Users");
           if(collection.find(
                   new Document("studentNo", studentNo)
           ).first() != null){
               return true;
           }
           return false;
       }catch (Exception e){
           throw new RuntimeException("Error while checking user in DB");
       }
    }

    /**
     * @desc: this func will return true if the user is in the DB, else will return false
     * @param: name, password
     * @return: boolean
     * @example: checkUserWithName(name, password);
     */

        public static boolean checkUser(String name, String password) {

            try {
                MongoCollection collection = DB_helpers.getCollection("Users");
                if (collection.find(
                        new Document("name", name)
                ).first() != null) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                throw new RuntimeException("Error while checking user in DB");
            }
        }


    /**
    *   @desc: this func will add a new user to the DB
    *   @param: name, password
     *   @return: void
     *
    * */

    public static void CreateAccount(Admin admin){
        try{
            MongoCollection collection = DB_helpers.getCollection("Users");

            if (checkUser(admin.getUsername())){

                AlertHandlerError.showAlert("Error", "User already exists", "Please try again");
                return;
            }


            String haspass= BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());

            collection.insertOne(new Document("name",admin.getUsername())
                    .append("password", haspass)
                    .append("email", admin.getEmail())
                    .append("phone", admin.getPhone())
                    .append("address", admin.getAddress())
                    .append("role", admin.getRole())
                            .append("salary", admin.getSalary())

                    .append("_id", new ObjectId())



            );

            AlertSucc.showAlert("Success", "User added successfully", "You can now login");

            Navigator.NavigateTo("login.fxml", "login Page", 691, 469);
        }catch (Exception e){
            throw new RuntimeException("Error while adding user to DB");
        }
    }
    /**
     *  @desc: this func login the user
     *  @param: name, password
     *  @return: void
     *
     */

    public static void Login(String name, String password) {
        try {
            ContextApi contextApi = ContextApi.getInstance();
            MongoCollection collection = DB_helpers.getCollection("Users");

            if (!checkUser(name, password) && !checkUser(name)) {

                AlertHandlerError.showAlert("Error", "User does not exists", "Please try again");
                return;
            }

            Document user = (Document) collection.find(
                    new Document("name", name)
            ).first();

            if (BCrypt.checkpw(password, user.getString("password"))) {

                User user1 = new User();
                user1.setUsername(user.getString("name"));
                user1.setPassword(user.getString("password"));
                user1.setEmail(user.getString("email"));
                user1.setPhone(user.getString("phone"));
                user1.setAddress(user.getString("address"));
                user1.setRole(user.getString("role"));
                user1.set_id(user.getObjectId("_id"));



                    Admin admin1 = new Admin();
                    admin1.setUsername(user1.getUsername());
                    admin1.setPassword(user1.getPassword());
                    admin1.setEmail(user1.getEmail());
                    admin1.setPhone(user1.getPhone());
                    admin1.setAddress(user1.getAddress());
                    admin1.setRole(user1.getRole());
                    admin1.set_id(user1.get_id());
                    admin1.setSalary(user.getString("salary"));
                    contextApi.setCurrentAdmin(admin1);
                    AlertSucc.showAlert("Success", "Login Successful", "Welcome Admin");





                Navigator.NavigateTo("dashboard.fxml", "Admin Dashboard", 986, 600);
            } else {
                AlertHandlerError.showAlert("Error", "Wrong Password", "Please try again");
            }
        } catch (Exception e) {

            throw new RuntimeException(e.toString());

        }
    }
}
