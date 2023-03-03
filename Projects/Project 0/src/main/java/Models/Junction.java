package Models;

import Utils.PrintManager;

public class Junction {
    private int JUNCTION_ID, ACCOUNT_ID, CUSTOMER_ID = 0;
    private PrintManager pm = PrintManager.getPM();

    /**
     * Non-Parameterized Constructor.
     * Sets values to the current customer's bank account and the current customer
     */
    public Junction() {
        this.ACCOUNT_ID = pm.getCurrentAccount().getAccID();
        this.CUSTOMER_ID = pm.getCurrentCustomer().getCusID();
    }

    /**
     * Parameterized Constructor
     *
     * @param JUNCTION_ID is set from fetching DB data
     * @param ACCOUNT_ID  is set from fetching DB data
     * @param CUSTOMER_ID is set from fetching DB data
     */
    public Junction(int JUNCTION_ID, int ACCOUNT_ID, int CUSTOMER_ID) {
        this.JUNCTION_ID = JUNCTION_ID;
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    /**
     * Parameterized Constructor
     * When there is no active user logged in, set account_id and customer_id
     *
     * @param ACCOUNT_ID  manually set from a newly created ACCOUNT object
     * @param CUSTOMER_ID manually set from a newly created CUSTOMER object
     */
    public Junction(int ACCOUNT_ID, int CUSTOMER_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getJunctionID() {
        return JUNCTION_ID;
    }

    public void setJunctionID(int JUNCTION_ID) {
        this.JUNCTION_ID = JUNCTION_ID;
    }

    public int getAccountID() {
        return ACCOUNT_ID;
    }

    public void setAccountID(int ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public int getCustomerID() {
        return CUSTOMER_ID;
    }

    public void setCustomerID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public String toString() {
        return "Junction ID: \n" + getJunctionID() +
                "Account ID: \n" + getAccountID() +
                "Customer ID: \n" + getCustomerID();
    }
}
