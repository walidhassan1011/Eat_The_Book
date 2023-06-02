package EatTheBook.DB;

import EatTheBook.Context.ContextApi;
import EatTheBook.Models.Admin;
import EatTheBook.Models.Book;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mindrot.bcrypt.BCrypt;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class DB_helpers {

       public static MongoCollection getCollection(String collectionName){
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoCollection collection = mongoClient.getDatabase("test").getCollection(collectionName);
            return collection;
        }

        public static void main(String[] args) {
//            Book book = new Book("BookName", "Author", "category", "image", false);
//            MongoCollection collection = DB_helpers.getCollection("Books");
//            collection.insertOne(new Document("BookName", book.getBookName())
//                    .append("Author", book.getAuthor())
//                    .append("category", book.getCategory())
//                    .append("image", book.getImage())
//                    .append("brown", book.isBrown()
//            ));
//            collection.find(
//                    new Document("BookName", "BookName2")
//            ).forEach((Consumer<? super Document>) document -> {
//                book.setBookName(document.getString("BookName"));
//                book.setAuthor(document.getString("Author"));
//                book.setCategory(document.getString("category"));
//                book.setImage(document.getString("image"));
//                book.setBrown(document.getBoolean("brown"));
//                System.out.println(book.getBookName());
//            }
//            );
//            ArrayList<Book> books= new ArrayList<Book>();
//           books = DB_Books_Controller.getAllBooks();
//            for (Book book: books) {
//                System.out.println(book.getId());
//            }
//            System.out.println(Date.from(LocalDate.now().atStartOfDay().toInstant(
//                    java.time.ZoneOffset.UTC
//            )));
//            Book book = new Book();
//            book=DB_Books_Controller.getBookById(new ObjectId("647674d10323974c17bf5981"));
//            System.out.println(book.getBookName());
//            System.out.println(book.getAuthor());
            // hash password test
//            BCrypt bCrypt = new BCrypt();
//            String genc=bCrypt.hashpw("123456", bCrypt.gensalt());
//            System.out.println(genc);
//            System.out.println(bCrypt.checkpw("123456", genc));


                // add admin user to database




        }



}
