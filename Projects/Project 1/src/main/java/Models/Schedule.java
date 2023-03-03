package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * This class is used to declare the POJO, Schedule
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@Table(name = "SCHEDULES")
@Entity(name = "SCHEDULE")
public class Schedule {
    // Variables
    private Date arrivalTime, departureTime;
    private int scheduleID;
    // Many schedules, one station
    @ManyToOne(cascade = CascadeType.ALL)
    private Station station;

    @Id
    @Column(name = "SCHEDULE_ID", columnDefinition = "datetime")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    @Column(name = "DEPARTURE_TIME")
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name = "ARRIVAL_TIME")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}