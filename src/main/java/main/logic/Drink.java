package main.logic;

import lombok.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class Drink implements Serializable{
    private int id;
    private String name;
    private double price;
    private String type;
    private String available;
    private String servingTemperature;
    private double rating;

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", available='" + available + '\'' +
                ", servingTemperature='" + servingTemperature + '\'' +
                ", rating=" + rating +
                '}';
    }
}
