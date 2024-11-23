package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class WhoAreYouController {

    @FXML
    private RadioButton auctioneerRadioButton;

    @FXML
    private RadioButton buyerRadioButton;

    @FXML
    private RadioButton sellerRadioButton;

    @FXML
    private ToggleGroup userTypeGroup; // Group to ensure only one RadioButton can be selected

    @FXML
    void handleContinueButton(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) userTypeGroup.getSelectedToggle();

        if (selectedRadioButton != null) {
            String userType = selectedRadioButton.getText();

            switch (userType) {
                case "Auctioneer":
                    navigateTo("/fxml/auctioneerLoginOrSignup.fxml");
                    break;
                case "Buyer":
                	navigateTo("/fxml/buyerLoginOrSignup.fxml");
                    break;
                case "Seller":
                	navigateTo("/fxml/sellerLoginOrSignup.fxml");
                    break;
                default:
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No Role Selected");
            alert.setContentText("Please select a role before continuing.");
            alert.showAndWait();
        }
    }

    private void navigateTo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Get current stage
            Stage stage = (Stage) auctioneerRadioButton.getScene().getWindow();

            // Set new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showError("Navigation Error", "Failed to load the requested page.");
        }
    }

    private void showError(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
