package EatTheBook.Models;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Order {


        private ObjectId _id;
        private Integer studentNo;
        private ArrayList<Book> books=new ArrayList<>();

        private Double price=0.0;
        private ObjectId invoiceId;

    public ObjectId getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(ObjectId invoiceId) {
        this.invoiceId = invoiceId;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }


    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
       this.books = books;


    }

    public void clearOrder(){
        this.books.clear();
        this.price=0.0;

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public Order(Integer studentNo, ArrayList<Book> books, Double price, ObjectId invoice) {
            this.studentNo = studentNo;
            this.books = books;
            this.price = price;
            this.invoiceId = invoice;
            this._id = new ObjectId();
        }
        public Order(){

        }
}
