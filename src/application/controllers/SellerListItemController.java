package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SellerListItemController {

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> itemList; 

    // Method to handle the "Back" button action
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        try {
            // Load the Login Page FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerDashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) backButton.getScene().getWindow();

            // Set the scene to the Login Page
            stage.setScene(new Scene(root));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception properly (e.g., show an alert)
        }
    }

    // Method to fetch items from the database
    private void fetchItemsFromDatabase() {
        // TODO: Implement the logic to fetch items from the database and populate the itemList
    }

    // Method to initialize the controller (called automatically by JavaFX)
    @FXML
    public void initialize() {
        // Fetch items and display them in the ListView
        fetchItemsFromDatabase();
    }
}