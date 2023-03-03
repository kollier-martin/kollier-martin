package CodingChallenges;

import java.util.Scanner;

public class FavoriteNum {
    public static int favorite(int L, int R, int N, int A[]) {
        int result = 0;

        // L is the minimum value of the range, R is the highest
        //Write Your Logic Here:
        for (Integer i : A) {
            if (i >= L && i <= R) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // INPUT [uncomment & modify if required]
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int R = sc.nextInt();
        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // OUTPUT [uncomment & modify if required]
        System.out.print(favorite(L, R, N, A));
        sc.close();
    }
}
