package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SellerDashboardController {

    @FXML
    private Button listItemButton;

    @FXML
    private Button addItemButton;

    // Method to handle the "List Items" button click
    @FXML
    private void handleListItem(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerListItem.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) listItemButton.getScene().getWindow();

            // Set the scene 
            stage.setScene(new Scene(root));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception properly (e.g., show an alert)
        } 
    }

    // Method to handle the "Add Items" button click
    @FXML
    private void handleAddItem(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerAddItem.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) listItemButton.getScene().getWindow();

            // Set the scene 
            stage.setScene(new Scene(root));

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception properly (e.g., show an alert)
        } 
    }
}
