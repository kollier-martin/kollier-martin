package CodingChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SmallestInt {
    public static int smallInteger(int N, int X, int A[]) {
        //this is default OUTPUT. You can change it
        int result = 0;
        ArrayList<Integer> highestNumbers = new ArrayList<>();

        //WRITE YOUR LOGIC HERE:
        for (int j : A) {
            if (j == (X + 1)) {
                result = j;
                break;
            } else if (j > X) {
                highestNumbers.add(j);
            }

            Collections.sort(highestNumbers);
            result = highestNumbers.get(0);
        }

        return result;

        /* MY SOLUTION
        //this is default OUTPUT. You can change it
        int result = 0;
        int temp[] = new int[A.length];

        //WRITE YOUR LOGIC HERE:
        for (int i = 0; i < A.length; i++){
            if (A[i] > X){
                temp[i] = A[i];
                Arrays.sort(temp);
                result = temp[temp.length - 1];
                break;
            }
        }
        return result;
        */
    }

    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        System.out.print(smallInteger(N, X, A));
        sc.close();
    }
}
