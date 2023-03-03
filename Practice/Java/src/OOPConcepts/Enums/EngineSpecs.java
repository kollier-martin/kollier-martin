/**
 * Enumerator that contains the different build of engines and if it is boosted
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package OOPConcepts.Enums;

public enum EngineSpecs {
    I4, I6, V4, V6, V8, V10, V12, NA, Supercharged, TwinCharged, TurboCharged;

    @Override
    public String toString() {
        return switch (this) {
            case NA -> ("Naturally Aspirated");
            case Supercharged -> ("Supercharged");
            case TwinCharged -> ("Twin-Charged");
            case TurboCharged -> ("Turbo-Charged");
            default -> "";
        };
    }
}
