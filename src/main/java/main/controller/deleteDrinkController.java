package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.io.View;
import main.service.DrinkService;

public class deleteDrinkController {
    private final DrinkService service = new DrinkService();
    private final View view = new View();

    @FXML
    private Button deleteDrinkId;

    @FXML
    private TextField enterId;

    @FXML
    void deleteDrink() {
        try {
            service.deleteDrink(Integer.parseInt(enterId.getText()));
            Stage stage = (Stage) deleteDrinkId.getScene().getWindow();
            stage.close();
        }catch(Exception e) {
            view.showAlert("Error", "Please Enter Id");
        }
    }

    @FXML
    void initialize() {
        assert deleteDrinkId != null : "fx:id=\"deleteDrinkId\" was not injected: check your FXML file 'deleteDrinkPage.fxml'.";
        assert enterId != null : "fx:id=\"enterId\" was not injected: check your FXML file 'deleteDrinkPage.fxml'.";
    }
}
