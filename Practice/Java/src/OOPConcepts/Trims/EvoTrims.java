/**
 * This class contains the trim levels for the Mitsubishi Lancer Evolution
 * COMMENTS for variables below are in the TrimInterface
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package OOPConcepts.Trims;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EvoTrims implements TrimInterface {
    MR, GSR, Final;

    public static final Random RAND = new Random();
    private static final List<EvoTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();

    // This function returns a Random Trim based on this brand of car
    public static EvoTrims getRandTrim() {
        return VALUES.get(RAND.nextInt(SIZE));
    }

    // An override of toString to properly set the value of the name vehicle dependent of the trim
    @Override
    public String toString() {
        String name = "";
        switch (this) {
            case MR:
                name = "GR";
                break;
            case GSR:
                name = "MSR";
                break;
            case Final:
                name = "Final";
                break;
        }
        return name;
    }
}
