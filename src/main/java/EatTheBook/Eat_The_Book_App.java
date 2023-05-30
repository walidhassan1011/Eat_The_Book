package EatTheBook;

import com.example.eatthebook.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Eat_The_Book_App extends Application {
    private  double x=0;
    private double y=0;
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Eat_The_Book_App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.<Parent>load(), 691, 469);
    scene.setOnMousePressed((MouseEvent e)->{
            x=e.getSceneX();
            y=e.getSceneY();
    });
    scene.setOnMouseDragged((MouseEvent e)->{
            stage.setX(e.getSceneX()-x);
            stage.setY(e.getSceneY()-y);
    });
    stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
