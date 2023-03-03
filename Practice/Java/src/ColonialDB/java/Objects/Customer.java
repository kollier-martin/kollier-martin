/*
 * Class to represent the Customer Table from OracleColonial table
 *
 */

package Objects;

public class Customer {
    private String CUSTOMER_NUM, LAST_NAME, ADDRESS, FIRST_NAME,
            CITY, STATE, POSTAL_CODE, PHONE = " ";

    public Customer() {
    }

    public Customer(String CUSTOMER_NUM, String LAST_NAME, String ADDRESS, String FIRST_NAME, String CITY, String STATE, String POSTAL_CODE, String PHONE) {
        this.CUSTOMER_NUM = CUSTOMER_NUM;
        this.LAST_NAME = LAST_NAME;
        this.ADDRESS = ADDRESS;
        this.FIRST_NAME = FIRST_NAME;
        this.CITY = CITY;
        this.STATE = STATE;
        this.POSTAL_CODE = POSTAL_CODE;
        this.PHONE = PHONE;
    }

    public String getCUSTOMER_NUM() {
        return CUSTOMER_NUM;
    }

    public void setCUSTOMER_NUM(String CUSTOMER_NUM) {
        this.CUSTOMER_NUM = CUSTOMER_NUM;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    @Override
    public String toString() {
        return (this.CUSTOMER_NUM + ": " +
                this.LAST_NAME + ", " +
                this.FIRST_NAME + " | " +
                this.ADDRESS + " | " +
                this.CITY + " | " +
                this.STATE + " | " +
                this.POSTAL_CODE + " | " +
                this.PHONE);
    }
}
