package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.io.View;
import main.logic.Drink;
import main.service.DrinkService;
import java.util.List;

public class sortDrinksController {
    private final DrinkService service = new DrinkService();
    private final View view = new View();

    @FXML
    private TextField enterAfterPrice,enterBeforePrice;

    @FXML
    private Button sortAfter,sortBefore,sortByAvailability,sortByRating;

    @FXML
    void sortAfterPrice() {
        int price = Integer.parseInt(enterAfterPrice.getText().trim());
        if (price < 0) {
            view.showAlert("Error", "Price cannot be negative");
            return;
        }
        List<Drink> drinks = service.sortAfterPrice(price);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) sortAfter.getScene().getWindow()).close();
        } catch (Exception e) {
            view.showAlert("Error",e.getMessage());
        }
    }

    @FXML
    void sortBeforePrice() {
        int price = Integer.parseInt(enterBeforePrice.getText().trim());
        if (price < 0) {
            view.showAlert("Error", "Price cannot be negative");
            return;
        }
        List<Drink> drinks = service.sortBeforePrice(price);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) sortBefore.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error",e.getMessage());
        }
    }

    @FXML
    void sortDrinksByRating() {
        try {
            List<Drink> drinks = service.sortByRating();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) sortByRating.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error",e.getMessage());
        }
    }

    @FXML
    public void sortDrinksByAvailability() {
        try {
            List<Drink> drinks = service.sortByAvailability();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) sortByAvailability.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error",e.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert enterAfterPrice != null : "fx:id=\"enterAfterPrice\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
        assert enterBeforePrice != null : "fx:id=\"enterBeforePrice\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
        assert sortAfter != null : "fx:id=\"sortAfter\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
        assert sortBefore != null : "fx:id=\"sortBefore\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
        assert sortByAvailability != null : "fx:id=\"sortByAvailability\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
        assert sortByRating != null : "fx:id=\"sortByRating\" was not injected: check your FXML file 'sortDrinksPage.fxml'.";
    }

}
