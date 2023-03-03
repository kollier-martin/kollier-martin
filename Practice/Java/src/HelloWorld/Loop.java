package HelloWorld;

public class Loop {
    public static void main(String[] args) {
        int i = 0;
        System.out.print("I want my ");

        while (true) {
            System.out.print("baby back ");
            i++;

            if (i <= 3) {
                continue;
            }

            System.out.println("ribs.");
            break;
        }
    }
}
