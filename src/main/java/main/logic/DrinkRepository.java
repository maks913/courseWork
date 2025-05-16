package main.logic;
import java.io.File;
import java.util.List;

public interface DrinkRepository extends Repository<Drink> {
    void outputList(List<Drink> t, File file);
    void outputList(List<Drink> t, String fileName);

    List<Drink> readList(File file);
    List<Drink> readList(String fileName);
}