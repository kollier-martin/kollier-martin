package Models;

import java.io.PrintStream;
import java.util.Random;

public class Account {
    private int ACCOUNT_ID, BALANCE = 0;
    private String ACCOUNT_TYPE, ACCOUNT_NAME = "";
    private Random rand = new Random();

    /**
     * Non-Parametrized Constructor
     * ACCOUNT_ID is randomly generated
     */
    public Account() {
        this.ACCOUNT_ID = rand.nextInt(10000);
        this.BALANCE = 0;
    }

    /**
     * Used when ACCOUNT_NAME is not set
     *
     * @param ACCOUNT_TYPE Checking or Savings
     * @param BALANCE      Account balance
     */
    public Account(String ACCOUNT_TYPE, int BALANCE) {
        this.ACCOUNT_ID = rand.nextInt(10000);
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
        this.BALANCE = BALANCE;
    }

    /**
     * Used when ACCOUNT_NAME is set
     *
     * @param ACCOUNT_NAME Account nickname
     * @param ACCOUNT_TYPE Checking or Savings
     * @param BALANCE      Account balance
     */
    public Account(String ACCOUNT_NAME, String ACCOUNT_TYPE, int BALANCE) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
        this.ACCOUNT_ID = rand.nextInt(10000);
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
        this.BALANCE = BALANCE;
    }

    /**
     * @param ACCOUNT_NAME Account nickname
     * @param ACCOUNT_ID   Account ID
     * @param ACCOUNT_TYPE Checking or Savings
     * @param BALANCE      Account balance
     */
    public Account(String ACCOUNT_NAME, int ACCOUNT_ID, String ACCOUNT_TYPE, int BALANCE) {
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.BALANCE = BALANCE;
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getAccountName() {
        return ACCOUNT_NAME;
    }

    public void setAccountName(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getAccType() {
        return ACCOUNT_TYPE;
    }

    public void setAccType(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public int getAccID() {
        return ACCOUNT_ID;
    }

    public void setAccID(int ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public int getBalance() {
        return BALANCE;
    }

    public void setBalance(int BALANCE) {
        this.BALANCE = BALANCE;
    }

    public String toString() {
        PrintStream str = System.out.printf("'%s', {%s}, %d : [$%d]", getAccountName(),
                getAccType(), getAccID(), getBalance());

        return str.toString();
    }
}
