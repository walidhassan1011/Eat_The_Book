package EatTheBook.Models;

import EatTheBook.DB.DB_Books_Controller;
import EatTheBook.Helpers.IBook;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Book implements IBook {


    private String BookName;
    private ObjectId _id=new ObjectId();
    private String Author;
    private String category;
    private String image;
    private boolean brown=false;
    private Date createdDate;

    private int quantity;
    private Double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Book(String BookName, String Author, String category, String image, Double price, int quantity) {

        this.price = price;
        this.quantity = quantity;
        this.BookName = BookName;
        this.Author = Author;
        this.category = category;
        this.image = image;
        this.brown = false;
        this.createdDate = Date.from(LocalDate.now().atStartOfDay().toInstant(
                java.time.ZoneOffset.UTC
        ));
        this._id = new ObjectId();
    }
    public Book(){

    }
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBrown() {
        return brown;
    }

    public void setBrown(boolean brown) {
        this.brown = brown;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public static ArrayList<Book> getBooks(){
        return DB_Books_Controller.getAllBooks();
    }
    public static Book getBook(ObjectId id){
        return DB_Books_Controller.getBookById(id);
    }




}
