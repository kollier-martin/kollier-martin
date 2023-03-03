package Utils;

import DAOs.UserDAO;
import MyCollections.MyArrayList;
import Models.UserInfo;

import java.sql.SQLException;

public class CredentialChecker {
    public static CredentialChecker credentialChecker;

    public static CredentialChecker getManager() {
        if (credentialChecker == null) {
            credentialChecker = new CredentialChecker();
        }

        return credentialChecker;
    }

    /**
     * Checks DB to see if username and password match each other under the same Customer Account
     *
     * @param username The username to check with the database to see if it exists
     * @param password The password to check with the database to see if it exists
     * @return
     */
    public boolean verifyUser(String username, String password) {
        UserDAO userDAO = new UserDAO(ConnectionManager.conn);
        MyArrayList<UserInfo> users = new MyArrayList<>();
        boolean verified = false;

        try {
            users = userDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Table is not properly formatted or is invalid. Can not fetch data.");
        }

        for (UserInfo user : users) {
            if (user.getUSERNAME().equals(username) && user.getPASSWORD().equals(password)) {
                verified = true;
            }
        }

        return verified;
    }

    /**
     * This method verifies the syntax of the new account information given, before allowing account creation
     *
     * @param username The new username for account creation
     * @param password The new password for account creation
     * @return
     */
    public boolean isValid(String username, String password) {
        boolean userValid = false, passValid = false, createValid = false;
        char[] usernameElements = username.toCharArray();
        char[] passwordElements = password.toCharArray();

        for (Character c : usernameElements) {
            if (Character.isLetterOrDigit(c)) {
                userValid = true;
            }
        }

        for (Character c : passwordElements) {
            if (Character.isLetterOrDigit(c)) {
                passValid = true;
            }
        }

        if (userValid && passValid) {
            createValid = true;
        }

        return createValid;
    }
}

