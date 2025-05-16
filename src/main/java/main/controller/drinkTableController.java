package main.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.logic.Drink;
import main.service.DrinkService;
import java.util.List;

public class drinkTableController {
    private final DrinkService service = new DrinkService();

    @FXML
    private TableView<Drink> drinkTable;

    @FXML
    private TableColumn<Drink, Integer> ID;

    @FXML
    private TableColumn<Drink, String> NAME,AVAILABLE,SERVING,TYPE;

    @FXML
    private TableColumn<Drink, Double> PRICE,RATING;

    public void updateTable(List<Drink> drinks) {
        drinkTable.setItems(FXCollections.observableArrayList(drinks));
    }

    @FXML
    void initialize() {
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        AVAILABLE.setCellValueFactory(new PropertyValueFactory<>("available"));
        SERVING.setCellValueFactory(new PropertyValueFactory<>("servingTemperature"));
        RATING.setCellValueFactory(new PropertyValueFactory<>("rating"));
        updateTable(service.getAllDrinks());
    }
}
