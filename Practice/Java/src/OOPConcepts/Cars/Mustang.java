/**
 * Interface that establishes the method and variable that will be used to randomly decide a trim and store said value into the variable
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package OOPConcepts.Cars;

import OOPConcepts.Enums.EngineSpecs;
import OOPConcepts.Enums.Manufacturers;
import OOPConcepts.MainClasses.Car;
import OOPConcepts.MainClasses.Engine;
import OOPConcepts.Trims.MustangTrims;

public class Mustang extends Car implements VehicleInterface {
    MustangTrims trim;

    public Mustang() {
        setYear(2022);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Ford.toString());
        setName("Mustang");
        randomTrim();
    }

    public Mustang(MustangTrims trim) {
        setYear(2022);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Ford.toString());
        setName("Mustang");

        switch (trim) {
            case EcoBoost:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 310));
                setTrim(trim);
                break;
            case GT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 460));
                setTrim(trim);
                break;
            case Mach1:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 480));
                setTrim(trim);
                break;
            case GT500:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 760));
                setTrim(trim);
                break;
        }
    }

    @Override
    public void randomTrim() {
        trim = MustangTrims.getRandTrim();

        switch (trim) {
            case EcoBoost:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 310));
                setTrim(trim);
                break;
            case GT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 460));
                setTrim(trim);
                break;
            case Mach1:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 480));
                setTrim(trim);
                break;
            case GT500:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 760));
                setTrim(trim);
                break;
        }
    }
}
