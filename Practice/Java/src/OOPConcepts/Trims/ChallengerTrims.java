/**
 * This class contains the trim levels for the Dodge Challenger
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

public enum ChallengerTrims implements TrimInterface {
    SXT, SXTAWD, GT, RT, ScatPack, Hellcat, HellcatRedeye, SuperStock;

    public static final Random RAND = new Random();
    private static final List<ChallengerTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();

    // This function returns a Random Trim based on this brand of car
    public static ChallengerTrims getRandTrim() {
        return VALUES.get(RAND.nextInt(SIZE));
    }

    // An override of toString to properly set the value of the name vehicle dependent of the trim
    @Override
    public String toString() {
        String name = "";
        switch (this) {
            case SXT:
                name = ("SXT");
                break;
            case SXTAWD:
                name = "SXT AWD";
                break;
            case GT:
                name = "GT";
                break;
            case RT:
                name = ("RT");
                break;
            case ScatPack:
                name = ("Scat Pack");
                break;
            case Hellcat:
                name = ("Hellcat");
                break;
            case HellcatRedeye:
                name = ("Hellcat Redeye");
                break;
            case SuperStock:
                name = ("Super Stock");
                break;
        }
        return name;
    }
}
