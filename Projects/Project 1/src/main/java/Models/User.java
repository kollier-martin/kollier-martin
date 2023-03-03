package Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * This class is used to declare the POJO, User
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */
@Table(name = "USERS")
@Entity(name = "USER")
public class User {
    @Column(name = "USER_ID", columnDefinition = "BINARY(36)", unique = true)
    private UUID userID;
    @Id
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CHECKED_IN")
    private boolean checkedIn;
    @ManyToMany
    private List<Train> trainList = new LinkedList<>();
    // USER_ID is a FK on USERINFO
    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;

    /**
     * Non-Parameterized Constructor
     */
    public User() {

    }

    /**
     * Parameterized Constructor
     *
     * @param firstName First name of the user
     * @param lastName  Last name of the user
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User ID: " + userID + ", First Name: " + firstName +
                ", Last Name: " + lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}