package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to declare the POJO, Train
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@Table(name = "TRAINS")
@Entity(name = "TRAIN")
public class Train {
    @Id
    @Column(name = "TRAIN_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainID;
    @Column(name = "PASSENGERS")
    private int passengers;
    @Column(name = "TICKET_ID", unique = true)
    private int ticketID;
    @Column(name = "AVAILABLE")
    private boolean isAvailable;
    // JUNCTION TABLE CREATION
    @ManyToMany
    @JoinTable(name = "JUNCTION", joinColumns = {@JoinColumn(name = "TRAIN_ID")}, inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private List<User> userList = new LinkedList<>();
    // One train can have multiple tickets pointing to it
    @OneToMany
    @JoinColumn(name = "TRAIN_TICKET_FK")
    private List<Ticket> tickets;
    // Many trains to one station
    @ManyToOne
    @JoinColumn(name = "TRAIN_STATION_FK", nullable = false)
    private Station station;

    /**
     * Non-Parameterized Constructor
     */
    public Train() {
    }

    /**
     * Constructor for Train object
     *
     * @param passengers  Number of passengers boarding the train
     * @param isAvailable Available passenger spots left for this train reservation
     */
    public Train(int passengers, boolean isAvailable) {
        this.passengers = passengers;
        this.isAvailable = isAvailable;
    }

    public int getTrainId() {
        return trainID;
    }

    public void setTrainId(int id) {
        this.trainID = id;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengersOnTrip) {
        this.passengers = passengersOnTrip;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Train ID: " + getTrainId() + "," +
                " Passengers: " + getPassengers() + "," +
                " Station and Trip Info: " + station.toString() + "," +
                " Availability: " + isAvailable();
    }
}