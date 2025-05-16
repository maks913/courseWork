package main.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
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
    private TableColumn<Drink, String> NAME, AVAILABLE, SERVING, TYPE;

    @FXML
    private TableColumn<Drink, Double> PRICE, RATING;

    public void updateTable(List<Drink> drinks) {
        drinkTable.setItems(FXCollections.observableArrayList(drinks));
    }

    @FXML
    void initialize() {
        drinkTable.setEditable(true);

        ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        NAME.setCellFactory(TextFieldTableCell.forTableColumn());
        NAME.setOnEditCommit(event -> event.getRowValue().setName(event.getNewValue()));

        PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));
        PRICE.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        PRICE.setOnEditCommit(event -> event.getRowValue().setPrice(event.getNewValue()));

        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        TYPE.setCellFactory(TextFieldTableCell.forTableColumn());
        TYPE.setOnEditCommit(event -> event.getRowValue().setType(event.getNewValue()));

        AVAILABLE.setCellValueFactory(new PropertyValueFactory<>("available"));
        AVAILABLE.setCellFactory(TextFieldTableCell.forTableColumn());
        AVAILABLE.setOnEditCommit(event -> event.getRowValue().setAvailable(event.getNewValue()));

        SERVING.setCellValueFactory(new PropertyValueFactory<>("servingTemperature"));
        SERVING.setCellFactory(TextFieldTableCell.forTableColumn());
        SERVING.setOnEditCommit(event -> event.getRowValue().setServingTemperature(event.getNewValue()));

        RATING.setCellValueFactory(new PropertyValueFactory<>("rating"));
        RATING.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        RATING.setOnEditCommit(event -> event.getRowValue().setRating(event.getNewValue()));

        updateTable(service.getAllDrinks());

    }
}
