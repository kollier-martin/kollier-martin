package OOPConcepts.Test;

import OOPConcepts.Cars.Challenger;
import OOPConcepts.Cars.Charger;
import OOPConcepts.Cars.Evo;
import OOPConcepts.Cars.Mustang;
import OOPConcepts.MainClasses.Car;

import java.util.ArrayList;

public class TestClass {
    private static Challenger c1 = null;
    private static Charger c2 = null;
    private static Evo c3 = null;
    private static Mustang c4 = null;

    public static void main(String args[]) {
        // Initialize list to contain the created cars
        ArrayList<Car> randCars = new ArrayList<>();
        int i = 0;

        // This main function randomly generates cars using a given constructor
        // There is also a way to create your own personal car by passing a Trim level as a parameter during creation

        while (true) {
            c1 = new Challenger();
            c2 = new Charger();
            c3 = new Evo();
            c4 = new Mustang();
            randCars.add(c1);
            randCars.add(c2);
            randCars.add(c3);
            randCars.add(c4);
            i++;

            if (i <= 2) {
                continue;
            }

            System.out.println(randCars);
            System.out.println("Loop has ran " + (randCars.size() / 4) + " times.");
            break;
        }
    }
}