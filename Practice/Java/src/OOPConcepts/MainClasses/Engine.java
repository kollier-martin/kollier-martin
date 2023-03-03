package OOPConcepts.MainClasses;
/**
 * Engine class that contains the information of the engine that is contained within a created vehicle.
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

import OOPConcepts.Enums.EngineSpecs;

public class Engine {
    // Attributes of the Engine class
    private int horsePower = 0;
    private EngineSpecs engineType, boostType = null;

    // Base constructor
    public Engine() {
    }

    // Overloaded constructor for the explicit declaration of a type of engine
    public Engine(EngineSpecs boostType, EngineSpecs engineType, int horsePower) {
        this.boostType = boostType;
        this.engineType = engineType;
        this.horsePower = horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public EngineSpecs getBoostType() {
        return this.boostType;
    }

    // Setter methods for Engine class
    //region Setters
    public void setBoostType(EngineSpecs boostType) {
        this.boostType = boostType;
    }
    //endregion

    // Getter methods for Engine class
    //region Getters

    public EngineSpecs getEngineType() {
        return this.engineType;
    }

    public void setEngineType(EngineSpecs engineType) {
        this.engineType = engineType;
    }

    //endregion

    @Override
    public String toString() {
        return boostType + " " + engineType + ": " + horsePower;
    }
}
