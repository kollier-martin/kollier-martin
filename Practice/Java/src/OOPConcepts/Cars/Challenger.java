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
import OOPConcepts.Trims.ChallengerTrims;

public class Challenger extends Car implements VehicleInterface {
    ChallengerTrims trim;

    public Challenger() {
        setYear(2022);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Dodge.toString());
        setName("Challenger");
        randomTrim();
    }

    public Challenger(ChallengerTrims trim) {
        setYear(2022);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Dodge.toString());
        setName("Challenger");

        switch (trim) {
            case SXT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 292));
                setTrim(trim);
                break;
            case SXTAWD:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 305));
                setDrivetrain("AWD");
                setYear(2021);
                setTrim(trim);
                break;
            case RT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 370));
                setTrim(trim);
                break;
            case ScatPack:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 485));
                setTrim(trim);
                break;
            case Hellcat:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 717));
                setTrim(trim);
                break;
            case HellcatRedeye:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 797));
                setTrim(trim);
                break;
        }
    }


    @Override
    public void randomTrim() {
        trim = ChallengerTrims.getRandTrim();

        switch (trim) {
            case SXT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 292));
                setTrim(trim);
                break;
            case SXTAWD:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 300));
                setTrim(trim);
                setDrivetrain("AWD");
                break;
            case GT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 300));
                setTrim(trim);
                setDrivetrain("AWD");
                setYear(2021);
            case RT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 370));
                setTrim(trim);
                break;
            case ScatPack:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 485));
                setTrim(trim);
                break;
            case SuperStock:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 807));
                setYear(2021);
                setTrim(trim);
            case Hellcat:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 717));
                setTrim(trim);
                break;
            case HellcatRedeye:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 797));
                setTrim(trim);
                break;
        }
    }
}
