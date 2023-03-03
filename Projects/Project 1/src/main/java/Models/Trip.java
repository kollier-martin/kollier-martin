package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This class is used to declare the POJO, Trip
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */
@Table(name = "TRIPS")
@Entity(name = "TRIP")
public class Trip {
    @Id
    @Column(name = "TRIP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripID;
    @Column(name = "DEPARTURE_CITY")
    private String departureCity;
    @Column(name = "ARRIVAL_CITY")
    private String arrivalCity;
    // One trip can have many stations
    @OneToMany(cascade = CascadeType.ALL)
    private List<Station> stations;

    /**
     * Non-Parameterized Constructor
     */
    public Trip() {
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int id) {
        this.tripID = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station) {
        this.stations.add(station);
    }
}
