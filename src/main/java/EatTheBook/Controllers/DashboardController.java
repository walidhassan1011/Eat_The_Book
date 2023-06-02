package EatTheBook.Controllers;

import EatTheBook.Context.ContextApi;
import EatTheBook.DB.DB_Books_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Models.Book;
import EatTheBook.Models.Order;
import EatTheBook.Models.Student;
import EatTheBook.Models.User;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button Add_btn;

    @FXML
    private Label AuthorLabel;

    @FXML
    private AnchorPane Available_Books_Frame;

    @FXML
    private AnchorPane Brow_Book_Frame;
    @FXML
    private AnchorPane Orders_Frame;
    @FXML
    private AnchorPane Users_Frame;
    @FXML
    private TableColumn<Book,String> BookTitle_Tab;

    @FXML
    private TableView<Book> Book_Table;



    @FXML
    private Button Brow_Btn;

    @FXML
    private Label CategoryLabel;

    @FXML
    private Button Delete_Btn;

    @FXML
    private Button Order_Btn;

    @FXML
    private Label PriceLabel;

    @FXML
    private TableColumn<Book,Double> Price_Tab;

    @FXML
    private Label TitleLabel;



    @FXML
    private Button Users_Btn;

    @FXML
    private TextField add_Category;

    @FXML
    private TextField add_author;

    @FXML
    private TextField add_title;

    @FXML
    private Button arrow_btn;

    @FXML
    private TableColumn<Book,String> author_Tab;

    @FXML
    private Button available_Btn;

    @FXML
    private Button bars_btn;

    @FXML
    private TableColumn<Book,String> category_Tab;

    @FXML
    private Circle circle_img;

    @FXML
    private Button close_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private Button half_nav;

    @FXML
    private Button half_nav_2;

    @FXML
    private Button half_nav_3;

    @FXML
    private Button half_nav_4;

    @FXML
    private AnchorPane half_navbar;

    @FXML
    private ImageView img_Book;

    @FXML
    private ImageView img_Frame;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_center;

    @FXML
    private Button minimize_btn;

    @FXML
    private AnchorPane nav_form;

    @FXML
    private TextField add_price;
    @FXML
    private Circle small_circle;

    @FXML
    private Label userName;
    @FXML
    private Button Add_Cart_order;



    @FXML
    private TableColumn<Student,Double> Balance_tab;

    @FXML
    private TableColumn<Order,String> BookName_order;


    @FXML
    private TableView<Book> Book_Table2;

    @FXML
    private TableColumn<Student,Integer> Bookbuy_tab;

    @FXML
    private Button Delete_Btn2;

    @FXML
    private TableColumn<Student,String> Name_tab;

    @FXML
    private TableColumn<Order, ObjectId> OrderNo_order;




    @FXML
    private TextField Price_order;

    @FXML
    private TextField StudentNo_order;



    @FXML
    private TableView<Student> User_Frame_tab;



    @FXML
    private TextField add_address;


    @FXML
    private TextField add_email;

    @FXML
    private TextField add_name;

    @FXML
    private TextField add_phone;



    @FXML
    private Button add_user;



    @FXML
    private TextField bookName_order;

    @FXML
    private TableColumn<Student,Integer> book_browes_tab;

    @FXML
    private TableColumn<Book,Integer> Quantity_Tab;

    @FXML
    private Button delete_user;
    @FXML
    private TextField add_quantity;

    @FXML
    private TableColumn<Student,String> studentNo_Tab;

    ContextApi contextApi = ContextApi.getInstance();

    @FXML
    void QuantityUpdate(
            TableColumn.CellEditEvent<Book, Integer> event
    ) {
        Book_Table.setEditable(true);
        // get the selected item
        Book book = Book_Table.getSelectionModel().getSelectedItem();
        // get the new value
        Integer newValue = event.getNewValue();

        // check if the new value is null
        if (newValue == null) {
            AlertHandlerError.showAlert("Error", "Please enter a quantity", "Please enter a quantity");
            return;
        }
        // check if the new value is a number
        try {
            Integer.parseInt(newValue.toString());
        } catch (NumberFormatException e) {
            AlertHandlerError.showAlert("Error", "Please enter a valid quantity", "Please enter a valid quantity");
            return;
        }
        book.setQuantity(newValue);
            contextApi.getCurrentAdmin().updateBook(book);
    }
    @FXML
    void priceUpdate(TableColumn.CellEditEvent<Book, Double> event) {
        // get the selected item

Book_Table.setEditable(true);
        Book book = Book_Table.getSelectionModel().getSelectedItem();
        // get the new value
        Double newValue = event.getNewValue();
        System.out.println(newValue);
        // check if the new value is null
        if (newValue == null) {
            AlertHandlerError.showAlert("Error", "Please enter a price", "Please enter a price");
            return;
        }
        // check if the new value is a number
        try {
            Double.parseDouble(newValue.toString());
        } catch (NumberFormatException e) {
            AlertHandlerError.showAlert("Error", "Please enter a valid price", "Please enter a valid price");
            return;
        }
        book.setPrice(newValue);
        // update the price of the book in the database

            contextApi.getCurrentAdmin().updateBook(book);

    }
    @FXML
    void deleteOrder_func(ActionEvent event) {

    }
    ArrayList<Student> Students = contextApi.getCurrentAdmin().getStudents();

    @FXML
    void addUser_func(ActionEvent event) {
        if (add_name.getText().isEmpty() || add_email.getText().isEmpty() || add_phone.getText().isEmpty() || add_address.getText().isEmpty()) {
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "Please fill all the fields");
            return;
        }
            Student student = new Student(
                    add_name.getText(),
        "123456",
                    add_email.getText(),
                    add_phone.getText(),
        add_address.getText(),
                    "Student",
                    0.00,
                    0,
                    0,
                    0
            );
            // clear the fields
            add_name.clear();
            add_email.clear();
            add_phone.clear();
            add_address.clear();

            contextApi.getCurrentAdmin().addStudent(student);
        // update the table
        User_Frame_tab.getItems().add(student);

    }

    @FXML
    void add_order_func(ActionEvent event) {

    }

    @FXML
    void deleteUser_func(ActionEvent event) {
        contextApi.getCurrentAdmin().deleteStudent(User_Frame_tab.getSelectionModel().getSelectedItem().get_id());

        // update the table
        User_Frame_tab.getItems().remove(User_Frame_tab.getSelectionModel().getSelectedItem());
    }
    @FXML
    void close() {
        System.exit(0);
    }

    @FXML
    void minimize() {
        Stage stage = (Stage) minimize_btn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
        public void sliderArrow(){
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(javafx.util.Duration.seconds(0.5));
            slide.setNode(nav_form);
            slide.setToX(-250);
            TranslateTransition slide1 = new TranslateTransition();
            slide1.setDuration(javafx.util.Duration.seconds(0.5));
            slide1.setNode(main_center);
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(javafx.util.Duration.seconds(0.5));
        slide2.setNode(half_navbar);
        slide2.setToX(0);
            slide1.setToX(-250+90);
            slide.setOnFinished((e)->{
                arrow_btn.setVisible(false);
                bars_btn.setVisible(true);
            });
        slide2.play();
            slide1.play();
            slide.play();

        }

        @FXML
        public void sliderBars(){
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(javafx.util.Duration.seconds(0.5));
            slide.setNode(nav_form);
            slide.setToX(0);
            TranslateTransition slide1 = new TranslateTransition();
            slide1.setDuration(javafx.util.Duration.seconds(0.5));
            slide1.setNode(main_center);

            slide1.setToX(0);
            TranslateTransition slide2 = new TranslateTransition();
            slide2.setDuration(javafx.util.Duration.seconds(0.5));
            slide2.setNode(half_navbar);
            slide2.setToX(-78);
            slide.setOnFinished((e)->{
                arrow_btn.setVisible(true);
                bars_btn.setVisible(false);
            });
            slide2.play();
            slide1.play();
            slide.play();

        }
    @FXML
    void addBook_func(ActionEvent event) {
        // get the values from the text fields
        String title = add_title.getText();
        String author = add_author.getText();
        String category = add_Category.getText();
        String price = add_price.getText();
        String quantity =add_quantity.getText();
        //convert the quantity to int
        int quantity_int = Integer.parseInt(quantity);

        if (title.isEmpty() || author.isEmpty() || category.isEmpty() || price.isEmpty()) {
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "Please fill all the fields");
            return;
        }
        if (!price.matches("[0-9]+")) {
            AlertHandlerError.showAlert("Error", "Please enter a valid price", "Please enter a valid price");
            return;
        }
        if (!quantity.matches("[0-9]+")) {
            AlertHandlerError.showAlert("Error", "Please enter a valid quantity", "Please enter a valid quantity");
            return;
        }
        // convert the price to double
        double price_double = Double.parseDouble(price);
        // create a new book object
        Book book = new Book(title,author,category,"www.google.com",price_double,quantity_int);
        // add the book to the database
        contextApi.getCurrentAdmin().addBook(book);
        // clear the text fields
        add_title.setText("");
        add_author.setText("");
        add_Category.setText("");
        add_price.setText("");
        add_quantity.setText("");
        // get all books and display them in the table
        ArrayList<Book> books = DB_Books_Controller.getAllBooks();
        // add books to the table view (table) in the dashboard page (Available_Books_Frame) in the title column (BookTitle_Tab)
        BookTitle_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("BookName"));
        author_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Author"));
        category_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Category"));
        Price_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,Double>("Price"));
        ObservableList<Book> list = FXCollections.observableArrayList(books);
        Book_Table.setItems(list);


    }
    @FXML
    void deleteBook_func(ActionEvent event) {
        // get the selected book
        Book selectedBook = Book_Table.getSelectionModel().getSelectedItem();
        // delete the book from the database
        contextApi.getCurrentAdmin().deleteBook(selectedBook.get_id());
        // update the table
        Book_Table.getItems().remove(selectedBook);
    }

    ArrayList<Book> books = Book.getBooks();
    ObservableList<Book> list = FXCollections.observableArrayList(books);
    @FXML
    void Book_Table_func(MouseEvent event) {
        Book_Table.setEditable(true);
            // get the selected book
            Book selectedBook = Book_Table.getSelectionModel().getSelectedItem();
            // display the book's image
            Book book = new Book();
            book.setBookName(selectedBook.getBookName());
            book.setAuthor(selectedBook.getAuthor());
            book.setCategory(selectedBook.getCategory());
            book.setPrice(selectedBook.getPrice());
            book.set_id(selectedBook.get_id());
              book.setQuantity(selectedBook.getQuantity());
            book.setImage(selectedBook.getImage());



    }
    @FXML
    void change_av_func(ActionEvent event) {
        // make the available books frame visible and the other frames invisible
        Available_Books_Frame.setVisible(true);
        Brow_Book_Frame.setVisible(false);
        Orders_Frame.setVisible(false);
        Users_Frame.setVisible(false);

    }
    @FXML
    void change_brow_func(ActionEvent event) {
        // make the browse books frame visible and the other frames invisible
        Available_Books_Frame.setVisible(false);
        Brow_Book_Frame.setVisible(true);
        Orders_Frame.setVisible(false);
        Users_Frame.setVisible(false);
    }

    @FXML
    void change_order_func(ActionEvent event) {
        // make the orders frame visible and the other frames invisible
        Available_Books_Frame.setVisible(false);
        Brow_Book_Frame.setVisible(false);
        Orders_Frame.setVisible(true);
        Users_Frame.setVisible(false);

    }
    @FXML
    void UpdateBlance(
            TableColumn.CellEditEvent<Student, Double> event
    ) {
        // get the new value

        Double newBalance = event.getNewValue();
        // get the selected user
        Student selectedStudent = User_Frame_tab.getSelectionModel().getSelectedItem();
        // check if the new balance is null
        if (newBalance == null) {
            AlertHandlerError.showAlert("Error", "Please enter a valid balance", "Please enter a valid balance");
            return;
        }
        // check if the new balance is negative
        if (newBalance < 0) {
            AlertHandlerError.showAlert("Error", "Please enter a valid balance", "Please enter a valid balance");
            return;
        }
        // check if the new balance is not a number
        if (!newBalance.toString().matches("[0-9]+")) {
            AlertHandlerError.showAlert("Error", "Please enter a valid balance", "Please enter a valid balance");
            return;
        }

        // update the user's balance
        selectedStudent.setBalance(newBalance);
        // update the user's balance in the database
        contextApi.getCurrentAdmin().updateStudent(selectedStudent);
    }

    @FXML
    void UpdateName(TableColumn.CellEditEvent<Student, String> event) {
        // get the new value
        String newName = event.getNewValue();
        // get the selected user
        Student selectedStudent = User_Frame_tab.getSelectionModel().getSelectedItem();
        // update the user's name
        selectedStudent.setUsername(newName);
        // update the user's name in the database
        contextApi.getCurrentAdmin().updateStudent(selectedStudent);
    }
    @FXML
    void change_user_func(ActionEvent event) {
        // make the users frame visible and the other frames invisible
        Available_Books_Frame.setVisible(false);
        Brow_Book_Frame.setVisible(false);
        Orders_Frame.setVisible(false);
        Users_Frame.setVisible(true);
        // get all users from the database


        // add users to the table view (table) in the dashboard page (Users_Frame) in the title column (User_Tab)
        studentNo_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Student,String>("studentNo"));
        Name_tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Student,String>("username"));
        Balance_tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Student,Double>("Balance"));
        Bookbuy_tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Student,Integer>("noOfBooksBuy"));
        book_browes_tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Student,Integer>("noOfBooksBrowed"));
        ObservableList<Student> list = FXCollections.observableArrayList(Students);
        User_Frame_tab.setItems(list);
        // make user frame editable
        User_Frame_tab.setEditable(true);
// make the balance column editable
        Balance_tab.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // get all books and display them in the table

        // add books to the table view (table) in the dashboard page (Available_Books_Frame) in the title column (BookTitle_Tab)



//              try
//              {
//                  Book_Table.setEditable(true);
//                  // make the balance column editable
//                  Price_Tab.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//                  Quantity_Tab.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//                    userName.setText(contextApi.getCurrentUser()!=null?contextApi.getCurrentUser().getStudentNo(): contextApi.getCurrentAdmin().getUsername());
//
//                  BookTitle_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("BookName"));
//                  author_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Author"));
//                  category_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Category"));
//                Price_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Price"));
//                Quantity_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
//
//
//
//                    Book_Table.setItems(list);
//              }catch (Exception e){
//                  System.out.println(e);
//              }
//         add all books in the database to the tree view table
        // get all books from the database












    }
}
