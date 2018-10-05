package WeatherWorld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("WeatherWorldFX.fxml"));
        stage.setTitle("WeatherWorld");
        stage.setScene(new Scene(root, 1024, 768));
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
        System.exit(1);
    }


}