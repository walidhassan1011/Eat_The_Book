package EatTheBook.Models;

public class Order {
        private String userAddress;
        private String bookId;
        private String bookName;

        private Double price;
        private String paymentMethod;

        public Order(Student student,Book book ,Double price, String paymentMethod) {
                this.userAddress = student.getAddress();

                this.bookName = book.getBookName();

                this.price = price;
                this.paymentMethod = paymentMethod;
        }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
