package io.beansprout.CodingChallenges;

public class DrawTriangles {
    public static void main(String[] args) {
        DrawTriangles triangleFactory = new DrawTriangles();

        triangleFactory.makeTriangles(4);
    }

    public void makeTriangles(int rows) {
        String aster = ("*");

        for (int tri = 1; tri <= 3; tri++) {//starts next triangle
            int t = 1;

            for (int s = 1; s <= rows; s++) { //creates a new line

                for (int l = 1; l <= t; l++) { //loops asterisks
                    System.out.print(aster);
                }

                System.out.println();
                t += 2;
            }
        }
    }
}
