package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Models.Book;
import EatTheBook.Models.Invoice;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

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
                order.setStudentNo( document.getInteger("studentNo"));
                order.setBooks((ArrayList) document.get("books"));
                order.setPrice(document.getDouble("price"));
                order.setInvoiceId(document.getObjectId("invoice"));
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


    public static Order getOrderById(ObjectId id) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Orders");
            Order order = new Order();
            collection.find(new Document("_id", id)).forEach((Consumer<? super Document>) document -> {
                order.set_id(document.getObjectId("_id"));
                order.setStudentNo( document.getInteger("studentNo"));
                order.setBooks(
                        (ArrayList) document.get("books")
                );
                order.setPrice(document.getDouble("price"));
                order.setInvoiceId(document.getObjectId("invoice"));
            });

            return order;
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Error while getting order by id", "Error while getting order by id");
            throw new RuntimeException("Error while getting order by id");
        }
    }
    /**
     *  @desc: this func is used to add order to the database
     *  @return: void
     *  @params: Order order
     *  @example: DB_Order_Controller.addOrder(order);
     *
    * */

    public static void addOrder(Order order) {

        try {
            MongoCollection collection = DB_helpers.getCollection("Orders");

            Document document = new Document();
            document.append("studentNo", order.getStudentNo());
            // loop through the books array and add each book to the document in one Array list of books
            ArrayList<Document> books = new ArrayList<Document>();
            for (Book book : order.getBooks()) {
                Document bookDocument = new Document();
                bookDocument.append("name", book.getBookName());
                bookDocument.append("price", book.getPrice());
                bookDocument.append("quantity", book.getQuantity());
                bookDocument.append("_id", book.get_id());
                bookDocument.append("author", book.getAuthor());
                bookDocument.append("category", book.getCategory());
                bookDocument.append("brown", book.isBrown());

                books.add(bookDocument);
            }
            document.append("books", books);
            document.append("_id", order.get_id());
            document.append("price", order.getPrice());
            document.append("invoice", order.getInvoiceId());
            collection.insertOne(document);

            AlertSucc.showAlert("Success", "Order added successfully", "Order added successfully");
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Error while adding order", "Error while adding order");
            throw new RuntimeException(e.toString());
        }
    }
    /**
     *  @desc: this func is used to delete order from the database
     *  @return: void
     *  @params: ObjectId id
     *  @example: DB_Order_Controller.deleteOrder("123");
     *
     * */

    public static void deleteOrder(ObjectId id) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Orders");
            collection.deleteOne(new Document("_id", id));
            AlertSucc.showAlert("Success", "Order deleted successfully", "Order deleted successfully");
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Error while deleting order", "Error while deleting order");
            throw new RuntimeException("Error while deleting order");
        }}


}

