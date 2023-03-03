/**
 * Customer Class
 * Contains the blueprint for a Customer
 *
 * @author Kollier Martin
 * @date
 */

package Models;

import java.util.Random;

public class Customer {
    private int CUSTOMER_ID, USER_ID = 0;
    private String FIRST_NAME, LAST_NAME, EMAIL = "";
    private Random rand = new Random();

    /**
     * Parameterized Constructor.
     *
     * @param CUSTOMER_ID The value that will be set to this.CUSTOMER_ID
     * @param EMAIL       The value that will be set to this.EMAIL
     * @param LAST_NAME   The value that will be set to this.LAST_NAME
     * @param FIRST_NAME  The value that will be set to this.FIRST_NAME
     */
    public Customer(int CUSTOMER_ID, String EMAIL, String LAST_NAME, String FIRST_NAME) {
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.EMAIL = EMAIL;
        this.LAST_NAME = LAST_NAME;
        this.FIRST_NAME = FIRST_NAME;
    }

    /**
     * Parameterized Constructor.
     *
     * @param EMAIL      The value that will be set to this.EMAIL
     * @param LAST_NAME  The value that will be set to this.LAST_NAME
     * @param FIRST_NAME The value that will be set to this.FIRST_NAME
     */
    public Customer(String EMAIL, String LAST_NAME, String FIRST_NAME) {
        this.CUSTOMER_ID = rand.nextInt(10000);
        this.EMAIL = EMAIL;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
    }

    public int getCusID() {
        return CUSTOMER_ID;
    }

    public void setCusID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String getFirstName() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public void setLastName(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public int getUserID() {
        return USER_ID;
    }

    public void setUserID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String toString() {
        return "Customer " + getCusID() + " - " + getEMAIL() + ", " + getLastName() + ", " + getFirstName();
    }
}
