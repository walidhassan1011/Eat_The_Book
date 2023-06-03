package EatTheBook.Models;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Invoice {
    private ObjectId _id;
    private Integer studentNo;
    private ArrayList<String> booksName=new ArrayList<>();
    private Double price;

    public ObjectId getOrderId() {
        return orderId;
    }

    public void setOrderId(ObjectId orderId) {
        this.orderId = orderId;
    }

    private ObjectId orderId;

    public ArrayList<String> getBooksName() {
        return booksName;
    }

    public void setBooksName(ArrayList<String> booksName) {
        this.booksName = booksName;
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


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice( Integer studentNo, ArrayList<String> BooksName, Double price, ObjectId orderId) {
        this._id = new ObjectId();
        this.studentNo = studentNo;
        this.booksName = BooksName;
        this.price = price;
        this.orderId = orderId;
    }
    public Invoice(){}

}
