package EatTheBook.Helpers;

import EatTheBook.Models.Book;
import EatTheBook.Models.Invoice;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IAdmin {
    ArrayList<Student> getStudents();
    Student getStudent(String id);
    Student getStudentByStudentNo(String studentNo);
    void addStudent(Student student);
    void deleteStudent(ObjectId id);
    void updateStudentOrders(Student student);
void updateStudent(Student student);
    void deleteBook(ObjectId id);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteOrder(ObjectId id);

    void updateOrder(ObjectId id);

    void addOrder(Order order);

    ArrayList<Order> getOrders();

    Order getOrder(ObjectId id);

    void deleteInvoice(ObjectId id);

    void updateInvoice(ObjectId id);

    ObjectId addInvoice(Invoice invoice);

    ArrayList<Invoice> getInvoices();

    Invoice getInvoice(ObjectId id);

}
