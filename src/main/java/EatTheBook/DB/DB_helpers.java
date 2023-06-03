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
            MongoCollection collection = mongoClient.getDatabase("EatTheBook").getCollection(collectionName);
            return collection;
        }



}
