package ToDoList;

import ToDoList.Models.ToDoItem;
import ToDoList.Utils.PrintView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // String for user input
        String input;

        for (String arg : args) {
            System.out.println(arg);
        }

        Scanner scan = new Scanner(System.in);

        //region List Creation
        List<ToDoItem> toDoList = new LinkedList<>();
        ToDoItem newItem1 = new ToDoItem("Build a to-do list.");
        toDoList.add(newItem1);
        ToDoItem newItem2 = new ToDoItem("Debug the new list.");
        toDoList.add(newItem2);
        ToDoItem newItem3 = new ToDoItem("Enjoy your new list.");
        toDoList.add(newItem3);
        //endregion

        //region Main Loop
        while (true) {
            System.out.println("""
                    ============= MAIN MENU ===============
                    Enter selection:

                    1) View ToDo Items
                    2) Mark Task Completed
                    3) Coming Soon!
                    Q) Quit""");

            input = scan.nextLine();

            switch (input) {
                case "1":
                    // Print out the To-Do List
                    System.out.println("============= To Do List: =============");

                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }

                    System.out.println("=======================================");
                    break;
                case "2":
                    // Mark To-Do item completed
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }

                    System.out.print("\nEnter item number to mark complete: ");
                    String itemNum = scan.nextLine();
                    toDoList.get(Integer.parseInt(itemNum)).setComplete(true);

                    System.out.println("\nItem: " + itemNum + " is complete!");
                case "3":

                    break;
                case "q":
                case "Q":
                    scan.close();
                    System.out.println("Quit Acknowledged. Goodbye!");
                    System.exit(0);
                    break;
            }
        }
        //endregion
    }
}
