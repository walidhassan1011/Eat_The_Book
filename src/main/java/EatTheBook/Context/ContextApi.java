package EatTheBook.Context;


import EatTheBook.Models.Admin;
import EatTheBook.Models.Student;
import EatTheBook.Models.User;

public class ContextApi {
    /**
     * @desc: This class is used to store the context of the application and the user who is currently logged in or current Admin logged in
     *
     */
    private Student CurrentUser;
    private Admin CurrentAdmin;

    private static ContextApi instance;
    public Student getCurrentUser() {
        return CurrentUser;
    }

    public Admin getCurrentAdmin() {
        return CurrentAdmin;
    }

    public void setCurrentUser(Student currentUser) {
        CurrentUser = currentUser;
    }

    public void setCurrentAdmin(Admin currentAdmin) {
        CurrentAdmin = currentAdmin;
    }

    public static ContextApi getInstance() {
        if (instance == null) {
            instance = new ContextApi();
        }
        return instance;
    }

    public void clearContext() {
        this.CurrentUser = null;
        this.CurrentAdmin = null;
    }



}
