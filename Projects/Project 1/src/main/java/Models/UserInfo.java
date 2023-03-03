package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * This class is used to declare the POJO, UserInfo
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */
@Table(name = "USER_INFOS")
@Entity(name = "USER_INFO")
public class UserInfo {
    @Column(name = "USER_ID", columnDefinition = "BINARY(36)", unique = true)
    private UUID userID;
    @Id
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    // WILL BE CONNECTED TO TICKETS, USERS, ROLES
    @OneToMany(mappedBy = "userInfo")
    private List<Ticket> tickets;
    @OneToOne(mappedBy = "userInfo")
    private User user;
    @ManyToOne
    private Role role;

    public UserInfo() {

    }

    public UserInfo(UUID userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User ID: " + getUserID() + ", Username: " + getUsername() +
                ", User Role: " + role.getUserRole() + "(" + role.getRoleID() + ")";
    }
}