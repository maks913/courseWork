package main.service;

import main.logic.Drink;
import main.logic.DrinkRepository;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DrinkRepositoryTxtIml implements DrinkRepository {
    public void outputList(List<Drink> Drinks, File file) {
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))) {
            if (Drinks != null) {
                for (Drink Drink : Drinks) {
                    out.println(Drink.getId() + ";" +
                            Drink.getName() + ";" +
                            Drink.getPrice() + ";" +
                            Drink.getType() + ";" +
                            Drink.getAvailable() + ";" +
                            Drink.getServingTemperature() + ";" +
                            Drink.getRating() +";");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputList(List<Drink> Drinks, String fileName) {
        File file = new File(fileName);
        outputList(Drinks, file);
    }

    @Override
    public List<Drink> readList(File file) {
        int size = 7;
        List<Drink> Drinks = new ArrayList<>();
        try (BufferedReader in = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens.length == size) {
                    Drinks.add(new Drink(
                            Integer.parseInt(tokens[0]),
                            tokens[1],
                            Double.parseDouble(tokens[2]),
                            tokens[3],
                            tokens[4],
                            tokens[5],
                            Double.parseDouble(tokens[6])
                    ));
                }
            }
            return Drinks;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Drink> readList(String fileName) {
        File file = new File(fileName);
        return readList(file);
    }
}