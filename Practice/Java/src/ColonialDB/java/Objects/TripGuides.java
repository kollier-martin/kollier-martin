/*
 * Class to represent the Guide Table from OracleColonial table
 *
 */

package Objects;

public class TripGuides {
    private int TRIP_ID;
    private String GUIDE_NUM;


    public TripGuides() {
    }

    public TripGuides(int TRIP_ID, String GUIDE_NUM) {
        this.TRIP_ID = TRIP_ID;
        this.GUIDE_NUM = GUIDE_NUM;
    }

    public int getTripID() {
        return TRIP_ID;
    }

    public void setTripID(int TRIP_ID) {
        this.TRIP_ID = TRIP_ID;
    }

    public String getGuideNum() {
        return GUIDE_NUM;
    }

    public void setGuideNum(String GUIDE_NUM) {
        this.GUIDE_NUM = GUIDE_NUM;
    }

    @Override
    public String toString() {
        return (this.TRIP_ID + " ~ " +
                this.GUIDE_NUM);
    }
}
