package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuyerLoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private void handleLogin(ActionEvent event) {
        // Get the entered user name and password
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Check if the credentials are valid (for simplicity, using hard coded values)
        if (validateLogin(username, password)) {
            // Show a success message (optional)
            showAlert(AlertType.INFORMATION, "Login Successful", "You are successfully logged in!");
            
            // You can proceed to navigate to another scene or perform other actions here
            // For example: 
            // Stage stage = (Stage) loginButton.getScene().getWindow();
            // stage.close();
            
        } else {
            // Show an error message if login fails
            showAlert(AlertType.ERROR, "Login Failed", "Invalid username or password. Please try again.");
        }
    }

    // Method to validate the login (you can modify this to use a database check or other logic)
    private boolean validateLogin(String username, String password) {
        // Hard coded validation for demonstration purposes
        // Replace this with actual validation logic (e.g., database check)
        return "auctioneer".equals(username) && "password123".equals(password);
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