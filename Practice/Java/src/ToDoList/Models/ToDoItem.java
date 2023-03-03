package ToDoList.Models;

public class ToDoItem {
    private String text = "";
    private boolean complete = false;

    public ToDoItem() {
        complete = false;
    }

    public ToDoItem(String item) {
        complete = false;
        this.text = item;
    }

    public String getToDoText() {
        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
