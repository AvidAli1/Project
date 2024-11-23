package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import Controller.itemManager;

import java.io.IOException;

public class SellerAddItemController {

    private itemManager itemManager = new itemManager(); // Assuming itemManager has the required methods

    @FXML
    private TextField itemIDField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField sellerIDField;

    @FXML
    private Button addItemButton;

    @FXML
    private Button backButton;

    @FXML
    private void handleAddItem(ActionEvent event) {
        // Collect input from fields
        String itemID = itemIDField.getText().trim();
        String priceText = priceField.getText().trim();
        String name = nameField.getText().trim();
        String quantityText = quantityField.getText().trim();
        String description = descriptionField.getText().trim();
        String sellerID = sellerIDField.getText().trim();

        // Validate input fields
        if (itemID.isEmpty() || priceText.isEmpty() || name.isEmpty() || quantityText.isEmpty() || sellerID.isEmpty()) {
            showAlert("Validation Error", "All fields except 'Description' must be filled!");
            return;
        }

        // Parse numerical inputs
        double price;
        int quantity;
        try {
            price = Double.parseDouble(priceText);
            quantity = Integer.parseInt(quantityText);

            if (price <= 0 || quantity <= 0) {
                showAlert("Validation Error", "Price and Quantity must be positive numbers!");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Validation Error", "Price must be a valid number and Quantity must be an integer!");
            return;
        }

        // Add the item using itemManager
        try {
            boolean success = itemManager.addItem(itemID, name, quantity, price, description, sellerID);
            if (success) {
                showAlert("Success", "Item added successfully!");
                clearFields();
            } else {
                showAlert("Error", "Item could not be added. It might already exist.");
            }
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred while adding the item.");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerDashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load the dashboard.");
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        itemIDField.clear();
        priceField.clear();
        nameField.clear();
        quantityField.clear();
        descriptionField.clear();
        sellerIDField.clear();
    }
}
