package Restaraunt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Receipt {
    private UUID uuid;
    private Date date;
    private int tableNum;
    private int numOfItems;
    private float total;

    public Receipt(int numOfItems, float total, int tableNum) {
        uuid = UUID.randomUUID();
        this.date = new Date();
        this.numOfItems = numOfItems;
        this.total = total;
        this.tableNum = tableNum;
    }
}
