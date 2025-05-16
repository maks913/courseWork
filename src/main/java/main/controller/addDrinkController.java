package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.io.View;
import main.logic.Drink;
import main.service.DrinkService;

public class addDrinkController{
    private final DrinkService service = new DrinkService();
    private final View view = new View();

    @FXML
    private Button addDrinkId;
    @FXML
    private TextField enterAvailable,enterId,enterPrice,enterName,enterRating,enterTemperature,enterType;

    @FXML
    void addDrink() {
        try {
            int id = Integer.parseInt(enterId.getText().trim());
            String name = enterName.getText().trim();
            double price = Double.parseDouble(enterPrice.getText().trim());
            String type = enterType.getText().trim();
            String available = enterAvailable.getText().trim();
            String servingTemp = enterTemperature.getText().trim();
            double rating = Double.parseDouble(enterRating.getText().trim());

            Drink drink = new Drink(id, name, price, type, available, servingTemp, rating);
            service.addDrink(drink);

            Stage stage = (Stage) addDrinkId.getScene().getWindow();
            stage.close();
        }catch (Exception e) {
            view.showAlert("Error", "Please enter valid data");
        }
    }

    @FXML
    void initialize() {
        assert addDrinkId != null : "fx:id=\"addDrinkId\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterAvailable != null : "fx:id=\"enterAvailable\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterId != null : "fx:id=\"enterId\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterPrice != null : "fx:id=\"enterPrice\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterName != null : "fx:id=\"enterName\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterRating != null : "fx:id=\"enterRating\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterTemperature != null : "fx:id=\"enterTemperature\" was not injected: check your FXML file 'addDrinkPage.fxml'.";
        assert enterType != null : "fx:id=\"enterType\" was not injected: check your FXML file 'addDrinkPage.fxml'.";

    }
}
