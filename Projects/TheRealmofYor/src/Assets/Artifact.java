package Assets;

public class Artifact extends Item {
    private int ID;
    private String name;
    private String desc;

    public Artifact(int ID, String name, String desc) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
    }

    /**
     * Returns the Artifacts item ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Returns the Artifacts item name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Artifacts item description
     */
    public String getDesc() {
        return desc;
    }
}
