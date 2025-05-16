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
import java.io.IOException;
import java.util.List;

public class findDrinksController {
    private final DrinkService service = new DrinkService();
    private final View view = new View();

    @FXML
    private Button findByNameBtn,findByTypeBtn,findByTempBtn,findByNRangeBtn;

    @FXML
    private TextField fromPrice,nameDrink,temperatureDrink,toPrice,typeDrink;

    @FXML
    void enterFindByName() {
        String name = nameDrink.getText().trim();
        if (name.isEmpty() || name.matches("\\d+")) {
            view.showAlert("Error", "Please enter a drink name");
            return;
        }
        List<Drink> drinks = service.findByName(name);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) findByNameBtn.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error", "Please enter a valid drink name");
        }
    }

    @FXML
    void enterFindByRangePrice() {
        try {
            int from = Integer.parseInt(fromPrice.getText().trim());
            int to = Integer.parseInt(toPrice.getText().trim());
            if (from < 0 || to < 0) {
                view.showAlert("Error", "Price cannot be negative");
                return;
            }
            if (from > to) {
                view.showAlert("Error", "Minimum price cannot be greater than maximum price");
                return;
            }
            List<Drink> drinks = service.findByRangePrice(from, to);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) findByNRangeBtn.getScene().getWindow()).close();
        } catch (NumberFormatException e) {
            view.showAlert("Error", "Please enter valid numbers for price range");
        } catch (IOException e) {
            view.showAlert("Error", "Failed to load drinks table view");
        }
    }

    @FXML
    void enterFindByTemperature() {
        String temperature = temperatureDrink.getText().trim();
        if (temperature.isEmpty() || temperature.matches("\\d+")) {
            view.showAlert("Error", "Please enter a serving temperature");
            return;
        }
        List<Drink> drinks = service.findByTemperatureServing(temperature);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) findByTempBtn.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error", "Please enter a valid drink temperature serving");
        }
    }

    @FXML
    void enterFindByType() {
        String type = typeDrink.getText().trim();
        if (type.isEmpty() || type.matches("\\d+")) {
            view.showAlert("Error", "Please enter a serving type");
            return;
        }
        List<Drink> drinks = service.findByType(type);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            drinkTableController table = loader.getController();
            table.updateTable(drinks);
            Stage stage = new Stage();
            stage.setTitle("Drink Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Stage) findByTypeBtn.getScene().getWindow()).close();
        }catch (Exception e){
            view.showAlert("Error", "Please enter a valid drink type");
        }
    }

    @FXML
    void initialize() {
        assert findByNRangeBtn != null : "fx:id=\"findByNRangeBtn\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert findByNameBtn != null : "fx:id=\"findByNameBtn\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert findByTempBtn != null : "fx:id=\"findByTempBtn\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert findByTypeBtn != null : "fx:id=\"findByTypeBtn\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert fromPrice != null : "fx:id=\"fromPrice\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert nameDrink != null : "fx:id=\"nameDrink\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert temperatureDrink != null : "fx:id=\"temperatureDrink\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert toPrice != null : "fx:id=\"toPrice\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
        assert typeDrink != null : "fx:id=\"typeDrink\" was not injected: check your FXML file 'findDrinksPage.fxml'.";
    }
}
