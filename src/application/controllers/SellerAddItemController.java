package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class SellerAddItemController {

    @FXML
    private TextField itemIDField;

    @FXML
    private TextField priceField;

    @FXML
    private Button addItemButton;

    @FXML
    private Button backButton;

    // Handle the action for the "Add Item" button
    @FXML
    private void handleAddItem(ActionEvent event) {
        String itemID = itemIDField.getText();
        String price = priceField.getText();

        // Validate input fields
        if (itemID.isEmpty() || price.isEmpty()) {
            showAlert("Validation Error", "Both fields must be filled!");
            return;
        }

        try {
            // Add item logic, for example saving the item to a database
            // Assuming a method addItemToDatabase that you will define later
            addItemToDatabase(itemID, price);
            
            // Show success message
            showAlert("Success", "Item added successfully!");

            // Optionally, clear fields after adding
            itemIDField.clear();
            priceField.clear();

        } catch (Exception e) {
            // Handle any other exception
            showAlert("Error", "There was an issue adding the item.");
            e.printStackTrace();
        }
    }

    // Handle the action for the "Back" button
    @FXML
    private void handleBack(ActionEvent event) throws IOException {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerDashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) backButton.getScene().getWindow();

            // Set the scene 
            stage.setScene(new Scene(root));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception properly (e.g., show an alert)
        } 
    }

    // Utility method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Placeholder method to simulate adding the item to a database (to be implemented)
    private void addItemToDatabase(String itemID, String price) {
        // Implement the logic to add the item to the database or data structure
        // Example: execute SQL to insert item details into a database
        System.out.println("Item added with ID: " + itemID + " and price: " + price);
    }
}