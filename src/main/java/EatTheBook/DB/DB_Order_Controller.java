package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Models.Invoice;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class DB_Order_Controller {
    /**
     * @desc: this func is used to get all orders from the database
     * @return: ArrayList<Order>
     * @params: none
     * @example: DB_Order_Controller.getOrders();
     *
     * */
    public static ArrayList<Order> getOrders(){
        try{
            MongoCollection collection = DB_helpers.getCollection("Orders");
            ArrayList<Order> orders = new ArrayList<Order>();
            collection.find().forEach((Consumer<? super Document>) document -> {
                Order order = new Order();
                order.set_id(document.getObjectId("_id"));
                order.setStudent((Student) document.get("student"));
                order.setBooks((ArrayList) document.get("books"));
                order.setPrice(document.getDouble("price"));
                order.setInvoice((Invoice) document.get("invoice"));
                orders.add(order);
            });

            return orders;
        }
        catch (Exception e){
            AlertHandlerError.showAlert("Error", "Error while getting all orders", "Error while getting all orders");
            throw new RuntimeException("Error while getting all orders");
        }

    }
    /**
     *  @desc: this func is used to get order by id from the database
     *  @return: Order
     *  @params: ObjectId id
     *  @example: DB_Order_Controller.getOrderById("123");
     * */


    public static Order getOrderById(String id) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Orders");
            Order order = new Order();
            collection.find(new Document("_id", id)).forEach((Consumer<? super Document>) document -> {
                order.set_id(document.getObjectId("_id"));
                order.setStudent((Student) document.get("student"));
                order.setBooks((ArrayList) document.get("books"));
                order.setPrice(document.getDouble("price"));
                order.setInvoice((Invoice) document.get("invoice"));
            });

            return order;
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Error while getting order by id", "Error while getting order by id");
            throw new RuntimeException("Error while getting order by id");
        }
    }


}

