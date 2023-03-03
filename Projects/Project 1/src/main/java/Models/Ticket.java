package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class is used to declare the POJO, Ticket
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@Table(name = "TICKETS")
@Entity(name = "TICKET")
public class Ticket {
    @Id
    @Column(name = "TICKET_ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    @Column(name = "DESCRIPTION")
    private String description;
    // FK for UserInfo
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME_TICKET_FK")
    private UserInfo userInfo;
    // FK for Train
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TRAIN_ID_FK")
    private Train train;

    /**
     * Non-Parameterized Constructor
     */
    public Ticket() {

    }

    public Ticket(String description) {
        this.description = description;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String departureCity, String arrivalCity, String departureStation, String arrivalStation, String departureDate, String arrivalDate) {
        this.description = departureStation + ": " + arrivalCity + " " + departureDate + "\n" +
                arrivalStation + ": " + departureCity + " " + arrivalDate;
    }

    public void setDescription(String currentCity, String departureTime, String destCity, String arrivalTime) {
        this.description = currentCity + " " + departureTime + "\n" +
                destCity + " " + arrivalTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return getTicketID() + ": " + getDescription();
    }
}