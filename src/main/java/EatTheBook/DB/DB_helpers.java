package EatTheBook.DB;

import EatTheBook.Models.Book;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.function.Consumer;

public class DB_helpers {

       public static MongoCollection getCollection(String collectionName){
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoCollection collection = mongoClient.getDatabase("test").getCollection(collectionName);
            return collection;
        }

        public static void main(String[] args) {
            Book book = new Book("BookName", "Author", "category", "image", false);
            MongoCollection collection = DB_helpers.getCollection("Books");
//            collection.insertOne(new Document("BookName", book.getBookName())
//                    .append("Author", book.getAuthor())
//                    .append("category", book.getCategory())
//                    .append("image", book.getImage())
//                    .append("brown", book.isBrown()
//            ));
            collection.find(
                    new Document("BookName", "BookName2")
            ).forEach((Consumer<? super Document>) document -> {
                book.setBookName(document.getString("BookName"));
                book.setAuthor(document.getString("Author"));
                book.setCategory(document.getString("category"));
                book.setImage(document.getString("image"));
                book.setBrown(document.getBoolean("brown"));
                System.out.println(book.getBookName());
            }
            );
        }

}
