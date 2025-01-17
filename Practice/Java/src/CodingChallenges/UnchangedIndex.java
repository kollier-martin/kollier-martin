package CodingChallenges;

import java.util.Arrays;
import java.util.Scanner;

public class UnchangedIndex {
    public static int unchangedIndex(int N, int A[]) {
        //this is default OUTPUT. You can change it
        int result = 0;
        int indexes[] = new int[N];

        //WRITE YOUR LOGIC HERE:
        System.arraycopy(A, 0, indexes, 0, A.length);

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] == indexes[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        System.out.print(unchangedIndex(N, A));
        sc.close();
    }
}


