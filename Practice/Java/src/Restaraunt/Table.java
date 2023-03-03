package Restaraunt;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Table {
    private int customers;
    private int numOfSeats;
    private int tableNumber;
    private int boosterSeats;
    private boolean occupied;

    public Table(int tableNumber, int numOfSeats) {
        occupied = false;
        this.tableNumber = tableNumber;
        this.numOfSeats = numOfSeats;
    }
}
