package EatTheBook.Helpers;

import EatTheBook.Models.Book;
import EatTheBook.Models.Student;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IAdmin {
    ArrayList<Student> getStudents();
    Student getStudent(String id);
    void addStudent(Student student);
    void deleteStudent(ObjectId id);
    void updateStudent(Student student);

    void deleteBook(ObjectId id);

    void addBook(Book book);

    void updateBook(Book book);

}
