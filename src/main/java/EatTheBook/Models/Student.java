package EatTheBook.Models;

public class Student extends User{
    private Double Balance;

    private int noOfBooksBrowed;
    private int noOfBooksBuy;
    private int noOfBooksReturned;



    public Student (String username, String password, String email, String phone, String address,String role,Double Balance
                    ,int noOfBooksBrowed,int noOfBooksBuy,int noOfBooksReturned
    ){

        super(username, password, email, phone, address,role= "Student");
        this.Balance=Balance;
        this.noOfBooksBrowed=noOfBooksBrowed;
        this.noOfBooksBuy=noOfBooksBuy;
        this.noOfBooksReturned=noOfBooksReturned;



    }
    public Student(){}

}
