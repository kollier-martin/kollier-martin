package Models;

public class UserInfo {
    private String USERNAME, PASSWORD;
    private int USER_ID;

    /**
     * Parametrized Constructor for UserInfo
     *
     * @param USERNAME
     * @param PASSWORD
     */
    public UserInfo(String USERNAME, String PASSWORD) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUserName(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getUserID() {
        return USER_ID;
    }

    public void setUserID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String toString() {
        return getUSERNAME() + " " +
                getPASSWORD() + " " +
                getUserID();
    }
}
