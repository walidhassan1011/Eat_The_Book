package EatTheBook.Controllers;

import EatTheBook.Context.ContextApi;
import EatTheBook.DB.DB_Books_Controller;
import EatTheBook.Helpers.AlertHandlerError;
import EatTheBook.Helpers.AlertSucc;
import EatTheBook.Helpers.Navigator;
import EatTheBook.Models.*;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.bson.types.ObjectId;
import org.mindrot.bcrypt.BCrypt;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    private TableView<Order> Order_table;

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




    @FXML
    private TableView<Book> Cart_Table;



    @FXML
    private Button Delete_item;



    @FXML
    private TableColumn<Order,Integer> OrderNo;


    @FXML
    private Label TotalPrice;
    @FXML
    private TableColumn<Order,Double> PriceOrder;


    @FXML
    private TableColumn<Book,Double> Price_Cart;

    @FXML
    private Button add_order;


    @FXML
    private Button delete_Order;


    @FXML
    private TableColumn<Book,String> BookName_Cart;

    @FXML
    private TableColumn<Book,String> BookName_brow;



    @FXML
    private TextField Brow_studentNo;

    @FXML
    private TableColumn<Book,Boolean> Brown_brow;






    @FXML
    private Button add_brow;


    @FXML
    private TableColumn<Book,String> author_brow;



    @FXML
    private TableView<Book> brow_table;



    @FXML
    private TableColumn<Book,String> category_brow;



    @FXML
    private TableColumn<Book,Double> price_brow;



    @FXML
    private Button Brow_btn;


    @FXML
    private Label invoice_invoiceId;

    @FXML
    private ImageView invoice_logo;

    @FXML
    private TextArea invoice_order;

    @FXML
    private Label invoice_order_id;

    @FXML
    private Label invoice_total_cost;
    @FXML
    private Label brow_author;

    @FXML
    private Label brow_category;

    @FXML
    private Label brow_price;

    @FXML
    private AnchorPane invoice_Frame;

    @FXML
    private Label brow_title;


    ContextApi contextApi = ContextApi.getInstance();
    @FXML
    void Signout_func(ActionEvent event) {


        try
        {
            contextApi.clearContext();
            Navigator.NavigateTo( "login.fxml", "Login",691, 469);
            logout_btn.getScene().getWindow().hide();
        }catch (Exception e){
            AlertHandlerError.showAlert("Error", "Something went wrong", "error");
        }
    }
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
        // if number is negative
        if (newValue < 0) {
            AlertHandlerError.showAlert("Error", "Please enter a valid quantity", "Please enter a valid quantity");
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
            // check if the new value is number
        if (newValue.isNaN()) {
            AlertHandlerError.showAlert("Error", "Please enter a valid price", "Please enter a valid price");
            return;
        }
        // check if the new value is null
        if (newValue == null) {
            AlertHandlerError.showAlert("Error", "Please enter a price", "Please enter a price");
            return;
        }
        // check if the new value is a number is negative
        if (newValue < 0) {
            AlertHandlerError.showAlert("Error", "Please enter a valid price", "Please enter a valid price");
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
    Order order = new Order();
    @FXML
    void deleteOrder_func(ActionEvent event) {
        Order order = Order_table.getSelectionModel().getSelectedItem();
        if (order == null) {
            AlertHandlerError.showAlert("Error", "Please select an order", "Please select an order");
            return;
        }
        contextApi.getCurrentAdmin().deleteOrder(order.get_id());
        Order_table.getItems().removeAll(order);

    }
    ArrayList<Student> Students = contextApi.getCurrentAdmin().getStudents();

    @FXML
    void addUser_func(ActionEvent event) {
        if (add_name.getText().isEmpty() || add_email.getText().isEmpty() || add_phone.getText().isEmpty() || add_address.getText().isEmpty()) {
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "Please fill all the fields");
            return;
        }
        String hashPassword= BCrypt.hashpw("12345678", BCrypt.gensalt());
            Student student = new Student(
                    add_name.getText(),
        hashPassword,
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
        int quantity_int;
        try{
             quantity_int = Integer.parseInt(quantity);
        }catch (NumberFormatException e){
            AlertHandlerError.showAlert("Error", "Please enter a valid quantity", "Please enter a valid quantity");
            return;
        }

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
        // check negative values
        if (quantity_int < 0) {
            AlertHandlerError.showAlert("Error", "Please enter a valid quantity", "Please enter a valid quantity");
            return;
        }



        // convert the price to double
        double price_double = Double.parseDouble(price);
        if (price_double < 0) {
            AlertHandlerError.showAlert("Error", "Please enter a valid price", "Please enter a valid price");
            return;
        }
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
        if (selectedBook == null) {
            AlertHandlerError.showAlert("Error", "Please select a book", "Please select a book");
            return;
        }
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
        invoice_Frame.setVisible(false);

    }
    @FXML
    void change_brow_func(ActionEvent event) {
        // make the browse books frame visible and the other frames invisible
        Available_Books_Frame.setVisible(false);
        Brow_Book_Frame.setVisible(true);
        Orders_Frame.setVisible(false);
        Users_Frame.setVisible(false);
        invoice_Frame.setVisible(false);
        // get all books and display them in the table
        ArrayList<Book> books = Book.getBrowedBooks();

        BookName_brow.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("BookName"));
        author_brow.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Author"));
        category_brow.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("category"));
        price_brow.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,Double>("price"));
        Brown_brow.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,Boolean>("brown"));
        ObservableList<Book> list = FXCollections.observableArrayList(books);
        brow_table.setItems(list);



    }
    @FXML
    void getBrow_book(MouseEvent event) {
        // select books in the table and display them in the text fields
        Book selectedBook = brow_table.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            brow_title.setText(selectedBook.getBookName());
            brow_author.setText(selectedBook.getAuthor());
            brow_category.setText(selectedBook.getCategory());
            brow_price.setText(String.valueOf(selectedBook.getPrice()));
        }

    }

    @FXML
    void add_new_brow(ActionEvent event) {
        // get the selected book and the student number from the text field and add the book to the student's browed books list in the database and update the table
        Book selectedBook = brow_table.getSelectionModel().getSelectedItem();
        String studentNo = Brow_studentNo.getText();
        if (selectedBook == null) {
            AlertHandlerError.showAlert("Error", "Please select a book", "Please select a book");
            return;
        }
        if (studentNo.equals("")) {
            AlertHandlerError.showAlert("Error", "Please enter a student number", "Please enter a student number");
            return;
        }
        // convert the student number to integer
        try {
            int studentNo_int = Integer.parseInt(studentNo);
        } catch (Exception e) {
            AlertHandlerError.showAlert("Error", "Please enter a valid student number", "Please enter a valid student number");
            return;
        }
        // update brown status in the database
        selectedBook.setBrown(true);
        // update quantity in the database
        selectedBook.setQuantity(selectedBook.getQuantity() - 1);
        contextApi.getCurrentAdmin().updateBook(selectedBook);
        // get the student from the database
        Student student = contextApi.getCurrentAdmin().getStudentByStudentNo(studentNo);
        // add the book to the student's browed books list in the database
        ArrayList<Book> browedBooks = student.getBooksBrowed();
        browedBooks.add(0,selectedBook);
        student.setBooksBrowed(browedBooks);
        student.setNoOfBooksBrowed(student.getNoOfBooksBrowed() + 1);
        // update the student in the database
        contextApi.getCurrentAdmin().updateStudentBrowed(student);
        contextApi.getCurrentAdmin().updateStudent(student);
        // update the table
       ArrayList<Book> books= Book.getBrowedBooks();
        ObservableList<Book> list = FXCollections.observableArrayList(books);
        brow_table.setItems(list);
        // display a success message
        AlertSucc.showAlert("Success", "Book added successfully", "Book added successfully");
    }

    @FXML
    void change_order_func(ActionEvent event) {
        // make the orders frame visible and the other frames invisible
        Available_Books_Frame.setVisible(false);
        Brow_Book_Frame.setVisible(false);
        Orders_Frame.setVisible(true);
        Users_Frame.setVisible(false);
        invoice_Frame.setVisible(false);
        // get all orders and display them in the table
        ArrayList<Order> orders = contextApi.getCurrentAdmin().getOrders();
        // add orders to the table view (table) in the dashboard page (Orders_Frame) in the title column (OrderID_Tab)
        OrderNo_order.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,ObjectId>("_id"));
        PriceOrder.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,Double>("price"));
        OrderNo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,Integer>("studentNo"));
//        BookName_order.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,String>("bookName"));
        ObservableList<Order> list = FXCollections.observableArrayList(orders);
        Order_table.setItems(list);


    }
    Double totalPrice = 0.0;
    Student student = new Student();
    @FXML
    void add_order_func(ActionEvent event) {
        // check if order is empty
        if (order.getBooks().isEmpty()) {
            AlertHandlerError.showAlert("Error", "Please add books to the order", "Please add books to the order");
            return;
        }

        // create a new Invoice object of the current order
        Invoice invoice=new Invoice();

        invoice.set_id(new ObjectId());
        invoice.setPrice(Double.parseDouble(TotalPrice.getText()));
        invoice.setStudentNo(order.getStudentNo());
        invoice.setOrderId(order.get_id());
        ArrayList<String> booksName=new ArrayList<>();
        for(Book book:order.getBooks()){
            booksName.add(book.getBookName());
        }

        invoice.setBooksName(booksName);
        // add the invoice to the database
        ObjectId invoinceId = contextApi.getCurrentAdmin().addInvoice(invoice);

        order.setInvoiceId(invoinceId);
            // update book quantity
            for (Book book : order.getBooks()) {
                book.setQuantity(book.getQuantity() - 1);
                System.out.println(book.getQuantity());
                contextApi.getCurrentAdmin().updateBook(book);
            }
        // add order to the database and update the table

        contextApi.getCurrentAdmin().addOrder(order);
        // update students orders ArrayList
        System.out.println(order.get_id());
        ArrayList<Order> studentOrders = student.getMyorders();
        studentOrders.add(0,order);

        student.setMyorders(studentOrders);

        // update student noOfbooksBuy
        student.setNoOfBooksBuy(student.getNoOfBooksBuy() + order.getBooks().size());
        // update student total money spent
        contextApi.getCurrentAdmin().updateStudentOrders(student);
        // update the table
        ArrayList<Order> orders = contextApi.getCurrentAdmin().getOrders();
        // add orders to the table view (table) in the dashboard page (Orders_Frame) in the title column (OrderID_Tab)
        OrderNo_order.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,ObjectId>("_id"));
        PriceOrder.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,Double>("price"));
        OrderNo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,Integer>("studentNo"));
//        BookName_order.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Order,String>("bookName"));
            ObservableList<Order> list = FXCollections.observableArrayList(orders);
            Order_table.setItems(list);
        TotalPrice.setText("");
        StudentNo_order.setText("");
            // make invoice frame visible and the other frames invisible
            invoice_Frame.setVisible(true);
            Available_Books_Frame.setVisible(false);
            Brow_Book_Frame.setVisible(false);
            Orders_Frame.setVisible(false);
            Users_Frame.setVisible(false);
            // display logo in the invoice frame from URL
            invoice_logo.setImage(
                    new Image("https://user-images.githubusercontent.com/95965261/234280247-5cecb0dc-e42a-46b5-ac86-d7fdd15dad81.png")
            );

            // display order details in the invoice frame
            invoice_order_id.setText(order.get_id().toString());
            invoice_invoiceId.setText(invoinceId.toString());
            // display every book in the order in the text area in the invoice frame
            for (Book book : order.getBooks()) {
            invoice_order.appendText(book.getBookName() + "\n");
            }

            // display the total price in the invoice frame
            invoice_total_cost.setText(order.getPrice().toString());
        // clear the cart and the total price and the student number
        order.clearOrder();

        totalPrice=0.0;
        // clear cart table
        Cart_Table.getItems().clear();



    }
    ArrayList<Book> orderBooks = new ArrayList<>();

    @FXML
    void add_order_cart(ActionEvent event) {

        // get the BookName from the text field and student number from the text field and the price from the text field
        String bookName = bookName_order.getText();
        String studentNo = StudentNo_order.getText();

        System.out.println(bookName);
        // check if the book name is empty or the student number is empty or the price is empty
        if (bookName.isEmpty() || studentNo.isEmpty() ) {
            AlertHandlerError.showAlert("Error", "Please fill all the fields", "Please fill all the fields");
            return;
        }
        // check if the student is exist
        student=contextApi.getCurrentAdmin().getStudentByStudentNo(studentNo);
        if (student == null) {
            AlertHandlerError.showAlert("Error", "This student is not exist", "This student is not exist");
            return;
        }



        // convert the student number to integer and the price to double
        int studentNo_int = Integer.parseInt(studentNo);

        // create a new order object

        Book book = new Book();


       book=Book.getBookByName(bookName);
       if (book.getQuantity()<=0){
           AlertHandlerError.showAlert("Error", "This book is not available", "This book is not available");
           return;
       }


         // add the book with the old books in the orderBooks arraylist
            orderBooks.add(book);

            System.out.println(orderBooks.size());
       // add book in arraylist of books in order and price and sudentNo
            order.setBooks(orderBooks);
            totalPrice += book.getPrice();
            order.setPrice(totalPrice);
            order.setStudentNo(studentNo_int);
            order.set_id(new ObjectId());

            // clear the text fields
            bookName_order.setText("");


            // add the bookName retuned from the function getBookByName to the table view cart



            // add the order to table view cart
            Price_Cart.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,Double>("price"));
            BookName_Cart.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("bookName"));

            // add the order to the table view
            Cart_Table.getItems().add(book);
            // convert the price to string
            String price = String.valueOf(order.getPrice());
            // display the price in the text field
            TotalPrice.setText(price);





    }



    @FXML
    void delete_iten_func(ActionEvent event) {
       // get the selected Book
        Book selectedOrder = Cart_Table.getSelectionModel().getSelectedItem();
        // check if the selected order is null
        if (selectedOrder == null) {
            AlertHandlerError.showAlert("Error", "Please select an order", "Please select an order");
            return;
        }
        // update the price

        totalPrice -= selectedOrder.getPrice();
        Double price = order.getPrice() - selectedOrder.getPrice();
        order.setPrice(price);

        // update the books
        order.getBooks().remove(selectedOrder);
        // update the total price
        TotalPrice.setText(String.valueOf(order.getPrice()));
        // update the order
        order.setBooks(order.getBooks());
        // update the order
        order.setPrice(order.getPrice());
        // update the order
        order.setStudentNo(order.getStudentNo());
        // update the order
        order.set_id(order.get_id());
        // update the order
        order.setInvoiceId(order.getInvoiceId());
        // remove the order from the table view
        Cart_Table.getItems().remove(selectedOrder);
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
        if (newBalance.isNaN()) {
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



              try
              {
                  Book_Table.setEditable(true);
                  // make the balance column editable
                  Price_Tab.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
                  Quantity_Tab.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                    userName.setText(contextApi.getCurrentUser()!=null?contextApi.getCurrentUser().getStudentNo(): contextApi.getCurrentAdmin().getUsername());
            books = Book.getBooks();
            list = FXCollections.observableArrayList(books);

                  BookTitle_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("BookName"));
                  author_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Author"));
                  category_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<Book,String>("Category"));
                Price_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("Price"));
                Quantity_Tab.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));



                    Book_Table.setItems(list);
              }catch (Exception e){
                  System.out.println(e);
              }
//         add all books in the database to the tree view table
        // get all books from the database












    }


}
