package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Models.Book;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DB_Users_Controller {

    /**
     * @desc: this func will return all Students in the DB
     * @param: none
     * @return: ArrayList<Student>
     *     @example: getAllStudents();
     */

    public static ArrayList<Student> getAllStudents() {
        try {
            MongoCollection collection = DB_helpers.getCollection("Users");
            ArrayList<Student> students = new ArrayList<Student>();
            collection.find(new
                    Document(
                    "role", "Student"
            )).forEach((Consumer<? super Document>) document -> {
                Student student = new Student();
                student.setStudentNo(document.getString("studentNo"));
                student.setUsername(document.getString("name"));
                student.setPassword(document.getString("password"));
                student.setEmail(document.getString("email"));
                student.setPhone(document.getString("phone"));
                student.setAddress(document.getString("address"));
                student.setNoOfBooksBuy(document.getInteger("noOfBooksBuy"));
                student.setNoOfBooksBrowed(document.getInteger("noOfBooksBrowed"));
                student.setBalance(document.getDouble("Balance"));
                student.setRole(document.getString("role"));
                student.set_id(document.getObjectId("_id"));
                student.setBooksBrowed((ArrayList<Book>) document.get("booksBrowed"));
                student.setMyorders((ArrayList<Order>) document.get("myorders"));
                students.add(student);
            });

            return students;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error while getting all students");
        }
    }

    /**
     * @desc: this func will update the student in the DB
     * @param: Student student
     * @return: void
     *    @example: updateStudent(student);
     *
     */
        public static void updateStudentOrders(Student student) {

              try{
                    MongoCollection collection = DB_helpers.getCollection("Users");
                    ArrayList<Order> orders=student.getMyorders();

                        // update student in DB

                    collection.updateMany(
                            new Document("_id", student.get_id()),
                            new Document("$push", new BasicDBObject("myorders", new Document("orderId", orders.get(0).get_id()).append("price",orders.get(0).getPrice())))

                    );
                    updateStudent(student);


                        AlertSucc.showAlert("successfully","Student Updated Successfully","Student Updated Successfully");

              }
                catch (Exception e){
                    AlertHandlerError.showAlert("Error while updating student","Error while updating student","Error while updating student");
                    throw new RuntimeException(e.toString());
                }


        }

    /**
     * @desc: this func will delete the student in the DB
     * @param: objectId
     * @return: void
     *   @example: deleteStudent(student);
     *
     * */
    public static void deleteStudent(ObjectId objectId) {
        try {
            MongoCollection collection = DB_helpers.getCollection("Users");
            // check if the student is already in the DB
            Document doc = (Document) collection.find(new Document("_id", objectId)).first();
            if(doc == null){
                AlertHandlerError.showAlert("Error", "Student not found", "Student not found");
                throw new RuntimeException("Student not found");
            }
            // delete Student data in DB
            collection.deleteOne(new Document("_id", objectId));
            AlertSucc.showAlert("successfully","Student Deleted Successfully","Student Deleted Successfully");
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error while deleting student","Error while deleting student","Error while deleting student");
            throw new RuntimeException("Error while deleting student");
        }
    }
    /**
     * @desc: this func will create the student in the DB
     * @param: Student student
     * @return: void
     *  @example: createStudent(student);
     *
     */

    public static void createStudent(Student student) {
       try
       {
           MongoCollection collection = DB_helpers.getCollection("Users");

           // check if the student is already in the DB
              Document doc = (Document) collection.find(new Document("_id", student.get_id())).first();
                    if(doc != null){
                        AlertHandlerError.showAlert("Error", "Student already exists", "Student already exists");
                        throw new RuntimeException("Student already exists");
                    }
           // loop through the myorders array and add each order to the document in one Array list of myorders
           ArrayList<Document> myorders = new ArrayList<Document>();

           for (Order order : student.getMyorders()) {
               Document doc1 = new Document();
               doc.append("studentNo", order.getStudentNo());

               doc.append("price", order.getPrice());
               doc.append("invoice", order.getInvoiceId());
               myorders.add(doc1);
           }


           // loop through the booksBrowed array and add each book to the document in one Array list of booksBrowed
           ArrayList<Document> booksBrowed = new ArrayList<Document>();
           for (Book book : student.getBooksBrowed()) {
               Document doc2 = new Document();
               doc.append("name", book.getBookName());
               doc.append("author", book.getAuthor());
               doc.append("price", book.getPrice());
               doc.append("quantity", book.getQuantity());
               doc.append("category", book.getCategory());

               doc.append("image", book.getImage());
               booksBrowed.add(doc2);
           }
           // insert Student data in DB
           Document document = new Document("name", student.getUsername())
                   .append("password", student.getPassword())
                   .append("email", student.getEmail())
                   .append("phone", student.getPhone())
                   .append("address", student.getAddress())
                   .append("noOfBooksBuy", student.getNoOfBooksBuy())
                   .append("noOfBooksBrowed", student.getNoOfBooksBrowed())
                   .append("Balance", student.getBalance())
                   .append("booksBrowed", booksBrowed)
                   .append("myorders", myorders)
                   .append("studentNo", student.getStudentNo())
                   .append("role", student.getRole())
                   .append("_id", student.get_id())
                   .append("noOfBooksReturned", student.getNoOfBooksReturned());
           collection.insertOne(document);
              AlertSucc.showAlert("successfully","Student Created Successfully","Student Created Successfully");
       }catch (Exception e)
       {
           AlertHandlerError.showAlert("Error while creating student","Error while creating student","Error while creating student");
           throw new RuntimeException("Error while creating student");
       }
    }
    /**
     * @desc: this func will get the student by studentNo
     * @param: String studentNo
     * @return: Student
     *  @example: getStudentByStudentNo(studentNo);
     *
     */

            public static Student getStudentByStudentNo(String studentNo){

                try {
                    MongoCollection collection = DB_helpers.getCollection("Users");
                    // check if the student is already in the DB
                    Document doc = (Document) collection.find(new Document("studentNo", studentNo)).first();
                    if(doc == null){
                        AlertHandlerError.showAlert("Error", "Student not found", "Student not found");
                        return null;
                    }
                    Student student = new Student();
                    student.setUsername(doc.getString("name"));
                    student.setPassword(doc.getString("password"));
                    student.setEmail(doc.getString("email"));
                    student.setPhone(doc.getString("phone"));
                    student.setAddress(doc.getString("address"));
                    student.setNoOfBooksBuy(doc.getInteger("noOfBooksBuy"));
                    student.setNoOfBooksBrowed(doc.getInteger("noOfBooksBrowed"));
                    student.setBalance(doc.getDouble("Balance"));
                    student.setBooksBrowed((ArrayList<Book>) doc.get("booksBrowed"));
                    student.setMyorders((ArrayList<Order>) doc.get("myorders"));
                    student.setStudentNo(doc.getString("studentNo"));
                    student.setRole(doc.getString("role"));
                    student.set_id((ObjectId) doc.get("_id"));
                    student.setNoOfBooksReturned(doc.getInteger("noOfBooksReturned"));

                    return student;


                }catch (Exception e){
                    AlertHandlerError.showAlert("Error while getting student","Error while getting student","Error while getting student");
                    throw new RuntimeException(e.getMessage());
                }




            }
                /**
                 * @desc: this func will update the student in the DB
                 * @param: Student student
                 * @return: void
                 * @example: updateStudent(student);
                 * */

                public static void updateStudent(Student student) {
                    try {
                        MongoCollection collection = DB_helpers.getCollection("Users");
                        // check if the student is already in the DB
                        Document doc = (Document) collection.find(new Document("_id", student.get_id())).first();
                        if (doc == null) {
                            AlertHandlerError.showAlert("Error", "Student not found", "Student not found");
                            throw new RuntimeException("Student not found");
                        }
                       // update student in database

                        Document document= new Document();
                        document.append("name", student.getUsername());
                        document.append("password", student.getPassword());
                        document.append("email", student.getEmail());
                        document.append("phone", student.getPhone());
                        document.append("address", student.getAddress());
                        document.append("noOfBooksBuy", student.getNoOfBooksBuy());
                        document.append("noOfBooksBrowed", student.getNoOfBooksBrowed());
                        document.append("Balance", student.getBalance());


                        document.append("studentNo", student.getStudentNo());
                        document.append("role", student.getRole());

                        collection.updateOne(new Document("_id", student.get_id()), new Document("$set", document));

                    } catch (Exception e) {
                        AlertHandlerError.showAlert("Error while updating student", "Error while updating student", "Error while updating student");
                        throw new RuntimeException(e.getMessage());
                    }
                }

    /**
     * @desc: this func will update booksBrowed in the student in the DB
     * @param: Student student
     * @return: void
     * @example: updateStudentBrowed(student);
     *
     */

        public static void updateStudentBrowed(Student student) {
                try{
                    // update student browed books in database
                    MongoCollection collection = DB_helpers.getCollection("Users");
                    ArrayList<Book> booksBrowed = student.getBooksBrowed();

                    collection.updateOne(new Document("_id", student.get_id()), new Document("$push", new BasicDBObject("booksBrowed", new Document("BookId", booksBrowed.get(0).get_id()).append("price",booksBrowed.get(0).getPrice()).append(
                            "bookname",booksBrowed.get(0).getBookName()
                    ))) );
                    updateStudent(student);

                }
                catch (Exception e){
                    AlertHandlerError.showAlert("Error while updating student","Error while updating student","Error while updating student");
                    throw new RuntimeException(e.getMessage());
                }
        }

}

