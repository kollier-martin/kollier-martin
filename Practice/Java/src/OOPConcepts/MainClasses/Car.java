package OOPConcepts.MainClasses;

/**
 * Car class that contains the information for a created vehicle.
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

public class Car {
    // Attributes of the Car class
    protected int year = 0;
    protected String carClass, name, manufacturer, drivetrain = "";
    protected Engine engine = null;
    protected Enum trim = null;

    // Empty Constructor
    public Car() {

    }

    // An override of toString to print the information the created Object
    @Override
    public String toString() {
        return (year + " " + trim.toString() + " " + manufacturer + " " + name +
                " " + drivetrain + " " + carClass + "\n" + engine.toString() + "hp\n\n");
    }

    // Getter methods for Car class
    //region Getters
    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    //endregion

    // Setter methods for Car class
    //region Setters

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getEngine() {
        return engine.toString();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Enum getTrim() {
        return trim;
    }

    public void setTrim(Enum trim) {
        this.trim = trim;
    }

    //endregion
}