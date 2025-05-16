package main.io;

import javafx.scene.control.Alert;

public class View {
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showAlertAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Program");
        alert.setHeaderText(null);
        alert.setContentText("Author: Balinskij Max. \nGroup: 2144.\nTopic of the course work: A desktop app for tracking drinks in a cafe.\n");
        alert.showAndWait();
    }
}
