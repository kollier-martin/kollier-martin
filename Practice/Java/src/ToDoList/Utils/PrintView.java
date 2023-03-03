package ToDoList.Utils;

import ToDoList.Models.ToDoItem;

public class PrintView {
    public static void printMyView(int i, ToDoItem item) {
        System.out.print(i + ") [");
        if (item.isComplete()) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
        System.out.println("] " + item.getToDoText());
    }
}
