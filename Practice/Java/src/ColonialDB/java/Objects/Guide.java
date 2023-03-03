/*
 * Class to represent the Guide Table from OracleColonial table
 *
 */

package Objects;

public class Guide {
    private String GUIDE_NUM, LAST_NAME, ADDRESS, FIRST_NAME,
            CITY, STATE, POSTAL_CODE, PHONE_NUM, HIRE_DATE = "";


    public Guide() {
    }

    public Guide(String GUIDE_NUM, String LAST_NAME, String ADDRESS, String FIRST_NAME, String CITY, String STATE, String POSTAL_CODE, String PHONE_NUM, String HIRE_DATE) {
        this.GUIDE_NUM = GUIDE_NUM;
        this.LAST_NAME = LAST_NAME;
        this.ADDRESS = ADDRESS;
        this.FIRST_NAME = FIRST_NAME;
        this.CITY = CITY;
        this.STATE = STATE;
        this.POSTAL_CODE = POSTAL_CODE;
        this.PHONE_NUM = PHONE_NUM;
        this.HIRE_DATE = HIRE_DATE;
    }

    public String getGUIDE_NUM() {
        return GUIDE_NUM;
    }

    public void setGUIDE_NUM(String GUIDE_NUM) {
        this.GUIDE_NUM = GUIDE_NUM;
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

    public String getPHONE_NUM() {
        return PHONE_NUM;
    }

    public void setPHONE_NUM(String PHONE_NUM) {
        this.PHONE_NUM = PHONE_NUM;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(String HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    @Override
    public String toString() {
        return (this.GUIDE_NUM + ": " +
                this.LAST_NAME + ", " +
                this.FIRST_NAME + " | " +
                this.ADDRESS + " | " +
                this.CITY + " | " +
                this.STATE + " | " +
                this.POSTAL_CODE + " | " +
                this.HIRE_DATE);
    }
}
