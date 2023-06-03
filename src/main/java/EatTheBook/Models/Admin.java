package EatTheBook.Models;

import EatTheBook.DB.DB_Books_Controller;
import EatTheBook.DB.DB_Invoice_Controller;
import EatTheBook.DB.DB_Order_Controller;
import EatTheBook.DB.DB_Users_Controller;
import EatTheBook.Helpers.IAdmin;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Admin extends User implements IAdmin {
        private String salary;
        public Admin(String username, String password, String email, String phone, String address,String role,String salary) {

            super(username, password, email, phone, address,role= "Admin");
            this.salary=salary;
        }
        public Admin(){}

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public ArrayList<Student> getStudents() {
        return DB_Users_Controller.getAllStudents();
    }

    @Override
    public Student getStudent(String id) {
        return null;
    }

    @Override
    public Student getStudentByStudentNo(String studentNo) {
        return DB_Users_Controller.getStudentByStudentNo(studentNo);
    }

    @Override
    public void addStudent(Student student) {
        DB_Users_Controller.createStudent(student);
    }


    @Override
    public void deleteStudent(ObjectId id) {
        DB_Users_Controller.deleteStudent(id);
    }

    @Override
    public void updateStudentOrders(Student student) {
        DB_Users_Controller.updateStudentOrders(student);
    }

    @Override
    public void updateStudent(Student student) {
        DB_Users_Controller.updateStudent(student);
    }

    @Override
    public void updateStudentBrowed(Student student) {
        DB_Users_Controller.updateStudentBrowed(student);
    }

    @Override
    public void deleteBook(ObjectId id) {
        DB_Books_Controller.deleteBookById(id);
    }

    @Override
    public void addBook(Book book) {
        DB_Books_Controller.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        DB_Books_Controller.updateBook(book);
    }

    @Override
    public void updateOrder(ObjectId id) {

    }

    @Override
    public void addOrder(Order order) {
        DB_Order_Controller.addOrder(order);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return DB_Order_Controller.getOrders();
    }

    @Override
    public Order getOrder(ObjectId id) {
        return DB_Order_Controller.getOrderById(id);
    }

    @Override
    public void deleteInvoice(ObjectId id) {

    }

    @Override
    public void updateInvoice(ObjectId id) {

    }

    @Override
    public ObjectId addInvoice(Invoice invoice) {
       return DB_Invoice_Controller.addInvoice(invoice);
    }

    @Override
    public ArrayList<Invoice> getInvoices() {
        return null;
    }

    @Override
    public Invoice getInvoice(ObjectId id) {
        return null;
    }

}
