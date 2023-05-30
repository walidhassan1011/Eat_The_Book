package EatTheBook.Models;

import java.time.LocalDate;
import java.util.Date;

public class Book {


    private String BookName;

    private String Author;
    private String category;
    private String image;
    private boolean brown=false;
    private LocalDate createdDate;

    public Book(String BookName, String Author, String category, String image, boolean brown) {
        this.BookName = BookName;
        this.Author = Author;
        this.category = category;
        this.image = image;
        this.brown = brown;
        this.createdDate = LocalDate.now();
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBrown() {
        return brown;
    }

    public void setBrown(boolean brown) {
        this.brown = brown;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
