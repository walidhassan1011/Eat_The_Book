package EatTheBook.Models;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Order {


        private ObjectId _id;
        private Student student;
        private ArrayList<Book> books;

        private Double price;
        private Invoice invoice;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Order(Student student, ArrayList<Book> books, Double price, Invoice invoice) {
            this.student = student;
            this.books = books;
            this.price = price;
            this.invoice = invoice;
            this._id = new ObjectId();
        }
        public Order(){

        }
}
