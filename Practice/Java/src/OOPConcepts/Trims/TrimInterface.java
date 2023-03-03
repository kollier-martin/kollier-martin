/**
 * Interface that establishes the methods and variables that will be used to determine what level trim a vehicle is
 * The plan here is to show that enumerators can contain functions and variables within them
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package OOPConcepts.Trims;

import java.util.List;
import java.util.Random;

public interface TrimInterface {
    // VALUES is a cached list of the values given in this enumerator
    List<Enum> VALUES = null;
    // SIZE is a final integer value declaring how big the VALUES list is
    int SIZE = 0;
    // Final Random variable used in the fetching of the random trim
    Random RAND = null;

    // Base method for returning a random trim
    static Enum getRandTrim() {
        return null;
    }
}
