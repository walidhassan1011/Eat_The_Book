package EatTheBook.Models;

import org.bson.types.ObjectId;

public class Invoice {
    private ObjectId _id;
    private ObjectId userId;
    private ObjectId bookId;
    private Book book;

    private User user;



    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getBookId() {
        return bookId;
    }

    public void setBookId(ObjectId bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Invoice(ObjectId invoiceId, ObjectId userId, ObjectId bookId, Book book, User user) {
        this._id = invoiceId;
        this.userId = userId;
        this.bookId = bookId;
        this.book = book;
        this.user = user;
    }

}
