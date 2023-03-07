package io.beansprout.CodingChallenges;

import java.util.Scanner;

public class CanWin {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        /*Move Backward: If cell i-1 exists and contains a 0, you can walk back to cell i-1.
          Move Forward:
            If cell i+1 contains a zero, you can walk to cell i-1 .
            If cell i+leap contains a zero, you can jump to cell i+leap.
            If you're standing in cell n-1 or the value of i+leap >= n, you can walk or jump off the end of the array and win the game.*/
        boolean win = false;
        int leapPos;

        for (int i = 0; i < game.length; i++) {
            if (game[i + 1] + leap == 0) {
                win = true;
            } else if (game[i + leap] == 0) {
                win = true;
            } else if (game[game.length - 1] >= game.length || game[i + leap] >= game.length) {
                win = true;
            } else {
                win = false;
            }
        }

        return win;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}