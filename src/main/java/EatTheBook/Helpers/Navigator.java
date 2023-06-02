package EatTheBook.Helpers;

import EatTheBook.Eat_The_Book_App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigator {
    public static void  NavigateTo(String URL,String Title,int v,int v1) throws IOException{
        FXMLLoader loader = new FXMLLoader(Eat_The_Book_App.class.getResource(URL));
        Scene scene = new Scene(loader.load(), v,v1);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setTitle(Title);
        stage.setScene(scene);
        stage.show();


    }

}
