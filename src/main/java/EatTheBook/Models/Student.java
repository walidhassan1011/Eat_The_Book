package EatTheBook.Models;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Student  extends User {
    private Double Balance;
private ArrayList<Book> booksBrowed;
private ArrayList<Order> myorders;
    private int noOfBooksBrowed=0;
    private int noOfBooksBuy=0;
    private int noOfBooksReturned=0;
    private String studentNo;



    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }




    public int getNoOfBooksBrowed() {
        return noOfBooksBrowed;
    }

    public void setNoOfBooksBrowed(int noOfBooksBrowed) {
        this.noOfBooksBrowed = noOfBooksBrowed;
    }

    public int getNoOfBooksBuy() {
        return noOfBooksBuy;
    }

    public void setNoOfBooksBuy(int noOfBooksBuy) {
        this.noOfBooksBuy = noOfBooksBuy;
    }

    public int getNoOfBooksReturned() {
        return noOfBooksReturned;
    }

    public void setNoOfBooksReturned(int noOfBooksReturned) {
        this.noOfBooksReturned = noOfBooksReturned;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public ArrayList<Book> getBooksBrowed() {
        return booksBrowed;
    }

    public void setBooksBrowed(ArrayList<Book> booksBrowed) {
        this.booksBrowed = booksBrowed;
    }

    public ArrayList<Order> getMyorders() {
        return myorders;
    }

    public void setMyorders(ArrayList<Order> myorders) {
        this.myorders = myorders;
    }

    public Student (String username, String password, String email, String phone, String address, String role, Double Balance
                    , int noOfBooksBrowed, int noOfBooksBuy, int noOfBooksReturned
    ){

        super(username, password, email, phone, address,role= "Student");
        this.Balance=Balance;
        this.noOfBooksBrowed=noOfBooksBrowed;
        this.noOfBooksBuy=noOfBooksBuy;
        this.noOfBooksReturned=noOfBooksReturned;
        this.booksBrowed=new ArrayList<Book>();
        this.myorders=new ArrayList<Order>();
        // generate student no from 6 digits in range 100000-999999
        this.studentNo=String.valueOf((int)(Math.random() * (999999 - 100000 + 1) + 100000));





    }
    public Student(){}

}
