package EatTheBook.Models;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String image;
    private String role;





    public User(String username, String password, String email, String phone, String address,String role) {
        setUserNameAndPassword(username, password);
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public User(String username, String password) {
        setUserNameAndPassword(username, password);


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {

    }



    public String getUsername() {
        return username;
    }

   private void setUserNameAndPassword(String username, String password) {
        if (username.length() < 6) {
            throw new IllegalArgumentException("Username must be at least 6 characters long");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
public String getRole() {
        return role;}

    }
