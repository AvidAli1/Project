package application.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import Controller.itemManager;
import Project.item;

public class SellerListItemController {

	itemManager item = new itemManager(); //item object that has display function
	
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
    	// Get all items from the database
        ArrayList<item> items = item.getAllItems();

        // Populate the ListView with item details
        for (item i : items) {
            String itemDetails = String.format("ID: %s | Name: %s | Quantity: %d | Price: %.2f | SellerID: %s",
                    i.getItemID(), i.getItemName(), i.getItemQuantity(), i.getPrice(), i.getSellerID());
            itemList.getItems().add(itemDetails); // Add formatted item details to the ListView
        }
    }

    // Method to initialize the controller (called automatically by JavaFX)
    @FXML
    public void initialize() {
        // Fetch items and display them in the ListView
        fetchItemsFromDatabase();
    }
}