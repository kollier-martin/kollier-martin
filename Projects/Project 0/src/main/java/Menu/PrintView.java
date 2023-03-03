package Menu;


import Utils.PrintManager;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class PrintView {
    protected Scanner scn;
    protected Class<?> viewerType;
    protected PrintManager pm;

    public PrintView(Class<?> viewerType, Scanner scn) {
        this.viewerType = viewerType;
        this.scn = scn;
        this.pm = PrintManager.getPM();
    }

    public Class<?> getViewerType() {
        return viewerType;
    }

    /**
     * The method to print the menu for the current menu being show
     *
     * @throws SQLException
     */
    public abstract void printMenu() throws SQLException;
}
