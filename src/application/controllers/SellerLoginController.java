package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Controller.sellerManager;

public class SellerLoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void handleLogin(ActionEvent event) {
    	sellerManager seller = new sellerManager();
    	
        // Get the entered user name and password
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        
        // Check if the credentials are valid (for simplicity, using hard coded values)
        if (seller.login(username, password)) {
            // Show a success message (optional)
            showAlert(AlertType.INFORMATION, "Login Successful", "You are successfully logged in!");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerDashboard.fxml"));
                Parent root = loader.load();

                // Set the scene and show the new stage
                Stage stage = (Stage) usernameTextField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Seller Dashboard");
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Error", "Failed to load Seller Dashboard.");
            }
            
        } else {
            // Show an error message if login fails
            showAlert(AlertType.ERROR, "Login Failed", "Invalid username or password. Please try again.");
        }
    }

    // Method to show alerts
    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}