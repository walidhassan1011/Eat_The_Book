package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Models.Book;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DB_Books_Controller {
    /**
     *   @desc: this function is used to add new book in the database
     *  @param: book object
     *   @return: void
     *   @example: addBook(book);
     * */

    public static void addBook(Book book){
        try{
            MongoCollection collection = DB_helpers.getCollection("Books");
            // check if the book is already exist
            if(getBookById(book.get_id()) != null) {
                AlertHandlerError.showAlert("Error", "Book already exist", "Book already exist");
                throw new RuntimeException("Book already exist");
            }
            // insert a book in the database
            collection.insertOne(new Document(
                    "_id", book.get_id())
                    .append("BookName", book.getBookName())
                    .append("Author", book.getAuthor())
                    .append("category", book.getCategory())
                    .append("image", book.getImage())
                    .append("brown", book.isBrown())
                    .append("createdDate", book.getCreatedDate())
                    .append("price", book.getPrice())
                    .append("quantity", book.getQuantity())

            );
            AlertSucc.showAlert(" Successfully ","Book added successfully", "Book added successfully");

        }   catch (Exception e){
            AlertHandlerError.showAlert("Error", "Error while adding new book", "Error while adding new book");
            throw new RuntimeException("Error while adding new book");
        }
    }

    /**
     * @desc: this function is used to get all books from the database
     * @param: void
     * @return: list<Book>
     * @example: getAllBooks();
     *
     */

    public static ArrayList<Book> getAllBooks() {
        try{
            MongoCollection collection = DB_helpers.getCollection("Books");
            ArrayList<Book> books = new ArrayList<Book>();
            collection.find().forEach((Consumer<? super Document>) document -> {
                Book book = new Book(document.getString("BookName"), document.getString("Author"), document.getString("category"), document.getString("image"), document.getDouble("price")
                        , document.getInteger("quantity"));
                book.set_id(document.getObjectId("_id"));
                book.setCreatedDate( document.getDate("createdDate"));
                books.add(book);
            });
            return books;
        }catch (Exception e){

            throw new RuntimeException("Error while getting all books");
        }
    }

    /**
     * @desc: this function is used to get Book by _Id books from the database and return it
     * @param: ObjectId
     * @return: Book
     * @example: getBookById(ObjectId);
     */

    public static Book getBookById(ObjectId id)  {
        try {
            MongoCollection collection = DB_helpers.getCollection("Books");
            Book book = new Book();
            collection.find(
                    new Document("_id", id)
            ).forEach((Consumer<? super Document>) document -> {
                book.setBookName(document.getString("BookName"));
                book.setAuthor(document.getString("Author"));
                book.setCategory(document.getString("category"));
                book.setImage(document.getString("image"));
                book.setBrown(document.getBoolean("brown"));
                book.set_id(document.getObjectId("_id"));
                book.setCreatedDate(document.getDate("createdDate"));
                book.setPrice(document.getDouble("price"));
                book.setQuantity(document.getInteger("quantity"));
            });
            return book;
        } catch (Exception e) {
            throw new RuntimeException("Error while getting book");

        }
    }

        /**
         *  @desc: this function is used to find and  delete Book by _Id books from the database
         *  @param: ObjectId
         *  @return: void
         *  @example: deleteBookById(ObjectId);
         *
         * */
        public static void deleteBookById (ObjectId id)  {
            try {
                MongoCollection collection = DB_helpers.getCollection("Books");
                // find book by id

                if(getBookById(id)==null){
                    AlertHandlerError.showAlert("Error", "Error while deleting book", "Error while deleting book");
                    throw new RuntimeException("Error while deleting book");
                }
                // delete book by id
                collection.deleteOne(new Document("_id", id));
                AlertSucc.showAlert(" Successfully ","Book deleted successfully", "Book deleted successfully");
            } catch (Exception e) {
                AlertHandlerError.showAlert("Error", "Error while deleting book", "Error while deleting book");
                throw new RuntimeException("Error while deleting book");
            }

        }

        /**
         *  @desc: this function is used to find all brown books from the database
         *  @param: null
         *  @return: list<Book>
         *  @example: getAllBrownBooks();
         *
         * */

        public static ArrayList<Book> getAllBrownBooks() {
            try {
                MongoCollection collection = DB_helpers.getCollection("Books");
                ArrayList<Book> books = new ArrayList<Book>();
                collection.find(new Document("brown", true)).forEach((Consumer<? super Document>) document -> {
                    Book book = new Book(document.getString("BookName"), document.getString("Author"), document.getString("category"), document.getString("image"),document.getDouble("price"),
                            document.getInteger("quantity")

                    );
                    book.set_id(document.getObjectId("_id"));
                    book.setCreatedDate(document.getDate("createdDate"));
                    books.add(book);
                });
                return books;
            } catch (Exception e) {
                throw new RuntimeException("Error while getting all books");
            }
        }

    /**
     *  @desc: this function is used to find all books by category from the database
     *  @param: String
     *  @return: list<Book>
     *  @example: getAllBooksByCategory(String);
     *
     * */

    public static ArrayList<Book> getAllBooksByCategory(String category) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Books");
            ArrayList<Book> books = new ArrayList<Book>();
            collection.find(new Document("category", category)).forEach((Consumer<? super Document>) document -> {
                Book book = new Book(document.getString("BookName"), document.getString("Author"), document.getString("category"), document.getString("image"),document.getDouble("price"),
                        document.getInteger("quantity"));
                book.set_id(document.getObjectId("_id"));
                book.setCreatedDate(document.getDate("createdDate"));
                books.add(book);
            });
            return books;
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all books");
        }
    }

    /**
     * @desc: this function is used to update book by _Id from the database
     * @param: ObjectId, Book
     * @return: void
     * @example: updateBookById(ObjectId, Book);
     */

    public static void  updateBook(Book book){
        try {
            MongoCollection collection = DB_helpers.getCollection("Books");
            // check if book is exist

            if ( getBookById(book.get_id()) == null) {
                AlertHandlerError.showAlert("Error", "Book not found", "Book not found");
                throw new RuntimeException("Book not found");
            }
            // update book by _Id
            collection.updateOne(
                    new Document("_id", book.get_id()),
                    new Document("$set", new Document("BookName", book.getBookName())
                            .append("Author", book.getAuthor())
                            .append("category", book.getCategory())
                            .append("image", book.getImage())
                            .append("brown", book.isBrown())
                            .append("createdDate", book.getCreatedDate())
                            .append("price", book.getPrice())
                            .append("quantity", book.getQuantity())
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException("Error while updating book");
        }
    }

}
