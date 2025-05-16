package main.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.io.View;
import main.service.DrinkService;

public class DrinkController {
    private final DrinkService service = new DrinkService();
    private final View view = new View();

    @FXML
    private AnchorPane Main;
    @FXML
    private Button about,add,allDrinksView,delete,exit,findView,load,save,sortView;

    @FXML
    void about() {
        view.showAlertAbout();
    }

    @FXML
    void addDrink() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/addDrinkPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Drink");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            view.showAlert("Error", "Add Drink" + e.getMessage());
        }
    }

    @FXML
    void allDrinks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/drinkTablePage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("All Drinks");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            view.showAlert("Error", "All Drinks Error" + e.getMessage());
        }
    }

    @FXML
    void deleteDrink() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/deleteDrinkPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Delete Drink");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            view.showAlert("Error", "Delete Drink" + e.getMessage());
        }
    }

    @FXML
    void exit() {
        Platform.exit();
    }

    @FXML
    void findDrinks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/findDrinksPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Find Drinks");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            view.showAlert("Error", "Find Drinks Error" + e.getMessage());
        }
    }

    @FXML
    void loadData() {
        try {
            service.readListTxt("Drinks.txt");
            view.showAlert("Load Data", "Load Data from filename Drinks.txt was successful");
        } catch (Exception e) {
            view.showAlert("Error", "Failed to load data from Drinks.txt: " + e.getMessage());
        }
    }

    @FXML
    void saveData() {
       try {
           service.outputListTxt("Drinks.txt");
           view.showAlert("Save data", "Save data to filename Drinks.txt was successful");
       }catch (Exception e){
           view.showAlert("Error", "Failed to save data to Drinks.txt: " + e.getMessage());
       }
    }

    @FXML
    void sortDrinks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/sortDrinksPage.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Sort Drinks");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            view.showAlert("Error", "Sort Drinks Error" + e.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert Main != null : "fx:id=\"Main\" was not injected: check your FXML file 'main.fxml'.";
        assert about != null : "fx:id=\"about\" was not injected: check your FXML file 'main.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'main.fxml'.";
        assert allDrinksView != null : "fx:id=\"allDrinksView\" was not injected: check your FXML file 'main.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'main.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'main.fxml'.";
        assert findView != null : "fx:id=\"findView\" was not injected: check your FXML file 'main.fxml'.";
        assert load != null : "fx:id=\"load\" was not injected: check your FXML file 'main.fxml'.";
        assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'main.fxml'.";
        assert sortView != null : "fx:id=\"sortView\" was not injected: check your FXML file 'main.fxml'.";
    }
}
