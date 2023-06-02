package EatTheBook.DB;

import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Models.Book;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
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
        public static void updateStudent(Student student) {
               try{
                   MongoCollection collection = DB_helpers.getCollection("Users");

                   // check if the student is already in the DB
                     Document doc = (Document) collection.find(new Document("_id", student.get_id())).first();
                        if(doc == null){
                            AlertHandlerError.showAlert("Error", "Student not found", "Student not found");
                            throw new RuntimeException("Student not found");
                        }
                   // update Student data in DB
                   collection.updateOne(
                           new Document("_id", student.get_id()),
                           new Document("$set", new Document("name", student.getUsername())
                                   .append("password", student.getPassword())
                                   .append("email", student.getEmail())
                                   .append("phone", student.getPhone())
                                   .append("address", student.getAddress())
                                   .append("noOfBooksBuy", student.getNoOfBooksBuy())
                                   .append("noOfBooksBrowed", student.getNoOfBooksBrowed())
                                   .append("Balance", student.getBalance())
                                   .append("booksBrowed", student.getBooksBrowed())
                                   .append("myorders", student.getMyorders())
                                   .append("studentNo", student.getStudentNo())
                                   .append("role", student.getRole())
                                   .append("_id", student.get_id())
                                   .append("noOfBooksReturned", student.getNoOfBooksReturned())
                           )
                   );

                     AlertSucc.showAlert("successfully","Student Updated Successfully","Student Updated Successfully");
               }catch (Exception e){
                   AlertHandlerError.showAlert("Error while updating student","Error while updating student","Error while updating student");
                   throw new RuntimeException("Error while updating student");
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
           // insert Student data in DB
           Document document = new Document("name", student.getUsername())
                   .append("password", student.getPassword())
                   .append("email", student.getEmail())
                   .append("phone", student.getPhone())
                   .append("address", student.getAddress())
                   .append("noOfBooksBuy", student.getNoOfBooksBuy())
                   .append("noOfBooksBrowed", student.getNoOfBooksBrowed())
                   .append("Balance", student.getBalance())
                   .append("booksBrowed", student.getBooksBrowed())
                   .append("myorders", student.getMyorders())
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

}

