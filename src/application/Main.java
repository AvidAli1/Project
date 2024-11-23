package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Relative path to the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WhoAreYou.fxml"));
            Parent root = loader.load();

            // Set up the scene
            Scene scene = new Scene(root);

            // Configure the stage
            primaryStage.setTitle("Auction Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

