package application.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class AuctioneerLoginOrSignupController {
	
	@FXML
	private Button loginButton;

	@FXML
	private Button signUpButton;

    @FXML
    private void handleLogin() {
    	try {
    		 // Load the Login Page FXML
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/auctioneerLogin.fxml"));
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

    @FXML
    private void handleSignUp() {
    	try {
      		 // Load the Sign Up Page FXML
      		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/auctioneerSignup.fxml"));
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
}
