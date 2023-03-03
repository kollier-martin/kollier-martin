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
 * This class is used to declare the POJO, Role
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@Table(name = "ROLES")
@Entity(name = "ROLE")
public class Role {
    // 0 Passenger, 1 Admin
    @Id
    @Column(name = "ROLE_ID", columnDefinition = "int default 0")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleID;
    @Column(name = "USER_ROLE")
    private String userRole;
    // ROLE_ID WILL BE A FK ON USERINFO
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserInfo> userInfo;

    public Role() {
    }

    public Role(int roleID) {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUserRole() {
        switch (roleID) {
            case 0:
                userRole = ("Passenger");
                break;
            case 1:
                userRole = ("Admin");
                break;
        }
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }
}