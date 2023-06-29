package io.beansprout.Restaraunt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String description;
    private String name;
    private double price;

    public Item(String description, String name, double price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public enum Category {
        BEVERAGES,
        SIDES,
        ENTREES,
        ALCOHOL,
        DESSERTS
    }
}
