package main.service;


import main.logic.Drink;
import main.logic.DrinkRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkService {
    public static List<Drink> drinks = new ArrayList<>();
    private final DrinkRepository repositoryTxt = new DrinkRepositoryTxtIml();

    public void outputListTxt(String fileName) {
        repositoryTxt.outputList(drinks, fileName);
    }

    public void readListTxt(String fileName) {
        drinks = repositoryTxt.readList(fileName);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void deleteDrink(int id) {
        drinks.removeIf(drink -> drink.getId() == id);
    }

    public List<Drink> getAllDrinks() {
        return drinks;
    }

    public List<Drink> findByName(String name) {
        return drinks.stream()
                .filter(drink -> drink.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Drink> findByRangePrice(int from, int to) {
        return drinks.stream()
                .filter(drink -> drink.getPrice() >= from && drink.getPrice() <= to)
                .collect(Collectors.toList());
    }

    public List<Drink> findByTemperatureServing(String temp) {
        return drinks.stream()
                .filter(drink -> drink.getServingTemperature().toLowerCase().contains(temp.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Drink> findByType(String type) {
        return drinks.stream()
                .filter(drink -> drink.getType().toLowerCase().contains(type.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Drink> sortByRating() {
        return drinks.stream()
                .sorted(Comparator.comparing(Drink::getRating).reversed())
                .collect(Collectors.toList());
    }

    public List<Drink> sortByAvailability() {
        return drinks.stream()
                .sorted(Comparator.comparing(
                        drink -> "Yes".equalsIgnoreCase(drink.getAvailable()),
                        Comparator.reverseOrder()
                ))
                .collect(Collectors.toList());
    }

    public List<Drink> sortAfterPrice(int price) {
        return drinks.stream()
                .filter(drink -> drink.getPrice() >= price)
                .sorted(Comparator.comparingDouble(Drink::getPrice))
                .collect(Collectors.toList());
    }

    public List<Drink> sortBeforePrice(int price) {
        return drinks.stream()
                .filter(drink -> drink.getPrice() <= price)
                .sorted(Comparator.comparingDouble(Drink::getPrice))
                .collect(Collectors.toList());
    }
}
