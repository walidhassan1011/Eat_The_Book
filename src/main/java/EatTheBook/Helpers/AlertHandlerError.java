package EatTheBook.Helpers;

public class AlertHandlerError {
    public AlertHandlerError() {
    }
    public static void showAlert(String title, String headerText, String contentText){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
