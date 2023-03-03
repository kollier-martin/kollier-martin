package CodingChallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueensAttack {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        // k = number of obstacles and [k][2] represents the obstacle positions
        // n = the number of rows and columns on the board
        // r_q , queens x position - c_q , queens y position

        int attacks = 0;

        // Depending on the queen's location, determine if moving is even possible
        // If closest spaces don't have an obstacle instantly add them to the attacks count
        // The Closest Obstacles
        List<List<Integer>> positions = new ArrayList<>();
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q - 1);
                add(c_q); // left
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q + 1);
                add(c_q); // right
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q);
                add(c_q + 1); // up
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q);
                add(c_q - 1); // down
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q + 1);
                add(c_q + 1); // top right
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q - 1);
                add(c_q + 1); // top left
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q + 1);
                add(c_q - 1); // bottom right
            }
        });
        positions.add(new ArrayList<Integer>() {
            {
                add(r_q - 1);
                add(c_q - 1); // bottom left
            }
        });

        for (int i = 0; i < obstacles.size(); i++) {
            // if any spot is an obstacle
            for (List<Integer> position : positions) {
                if (!Objects.equals(position, obstacles.get(i))) {
                    attacks++;
                }
            }
        }

        return attacks;
    }
}