package Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private String RESERVATION_ID, CUSTOMER_NUM, TRIP_DATE;
    private int TRIP_ID, NUM_PERSONS;
    private float TRIP_PRICE, OTHER_FEES;

    public Reservation() {

    }

    public Reservation(String RESERVATION_ID, String CUSTOMER_NUM, String TRIP_DATE, int TRIP_ID, int NUM_PERSONS, float TRIP_PRICE, float OTHER_FEES) {
        this.RESERVATION_ID = RESERVATION_ID;
        this.CUSTOMER_NUM = CUSTOMER_NUM;
        this.TRIP_DATE = TRIP_DATE;
        this.TRIP_ID = TRIP_ID;
        this.NUM_PERSONS = NUM_PERSONS;
        this.TRIP_PRICE = TRIP_PRICE;
        this.OTHER_FEES = OTHER_FEES;
    }

    public String getReservationID() {
        return RESERVATION_ID;
    }

    public void setReservationID(String reservationID) {
        this.RESERVATION_ID = reservationID;
    }

    public String getCustomerNum() {
        return CUSTOMER_NUM;
    }

    public void setCustomerNum(String CUSTOMER_NUM) {
        this.CUSTOMER_NUM = CUSTOMER_NUM;
    }

    public Date getTripDate() throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(TRIP_DATE);
    }

    public void setTripDate(String TRIP_DATE) {
        this.TRIP_DATE = TRIP_DATE;
    }

    public int getTripID() {
        return TRIP_ID;
    }

    public void setTripID(int TRIP_ID) {
        this.TRIP_ID = TRIP_ID;
    }

    public int getNumPersons() {
        return NUM_PERSONS;
    }

    public void setNumPersons(int NUM_PERSONS) {
        this.NUM_PERSONS = NUM_PERSONS;
    }

    public float getTripPrice() {
        return TRIP_PRICE;
    }

    public void setTripPrice(float TRIP_PRICE) {
        this.TRIP_PRICE = TRIP_PRICE;
    }

    public float getOtherFees() {
        return OTHER_FEES;
    }

    public void setOtherFees(float OTHER_FEES) {
        this.OTHER_FEES = OTHER_FEES;
    }

    @Override
    public String toString() {
        return (this.RESERVATION_ID + ": " +
                this.CUSTOMER_NUM + " | " +
                this.TRIP_DATE + " | " +
                this.TRIP_ID + " | " +
                this.NUM_PERSONS + " | " +
                this.TRIP_PRICE + " | " +
                this.OTHER_FEES);
    }
}
