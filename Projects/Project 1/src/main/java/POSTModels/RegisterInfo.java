package POSTModels;

/**
 * This class is used to handle POST Request data for the specified 'Register User' transaction
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/24/2021
 */

public class RegisterInfo {
    String firstname, lastname, username, password;

    public RegisterInfo() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
}
