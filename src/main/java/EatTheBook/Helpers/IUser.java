package EatTheBook.Helpers;

import EatTheBook.Models.Book;
import EatTheBook.Models.Invoice;
import EatTheBook.Models.Student;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IUser {

void makeOrder(Book book, int quantity, Student student);

void deleteOrder(ObjectId id);






}
