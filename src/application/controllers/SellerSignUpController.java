package application.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Controller.sellerManager; 

public class SellerSignUpController {

    // FXML fields linked to the UI components
    @FXML
    private Button signUpButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    // Method to handle Sign Up button action
    @FXML
    private void handleSignUp() {
    	sellerManager seller = new sellerManager();
    	
        // Retrieve input values
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();

        // Validate inputs (example: ensure no empty fields)
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        seller.addSeller(username, password, email, name);
        
        // TODO: Add actual sign-up logic (e.g., saving user to a database)
        System.out.println("Sign-Up Successful for:");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Name: " + name);
    }

    // Method to handle Login button action
    @FXML
    private void handleLogin() {
    	try {
   		 // Load the Login Page FXML
   		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sellerLogin.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) loginButton.getScene().getWindow();

            // Set the scene to the Login Page
            stage.setScene(new Scene(root));

            // Show the stage
            stage.show();
       } catch (IOException e) {
           e.printStackTrace();  // Handle the exception properly (e.g., show an alert)
       }
    }

    // Method to handle the Enter key press in the PasswordField
    @FXML
    private void handlePassSignup() {
        System.out.println("Enter key pressed in Password field.");
        handleSignUp(); // Optionally call the sign-up logic when Enter is pressed
    }
}
