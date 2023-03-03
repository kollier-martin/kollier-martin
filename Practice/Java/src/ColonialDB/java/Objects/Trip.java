package Objects;

public class Trip {
    private String STATE, START_LOCATION, TRIP_NAME, ACTIVITY, SEASON;
    private int TRIP_ID, DISTANCE, MAX_GRP_SIZE;

    public Trip() {

    }

    public Trip(String STATE, String START_LOCATION, String TRIP_NAME, String ACTIVITY, String SEASON, int TRIP_ID, int DISTANCE, int MAX_GRP_SIZE) {
        this.STATE = STATE;
        this.START_LOCATION = START_LOCATION;
        this.TRIP_NAME = TRIP_NAME;
        this.ACTIVITY = ACTIVITY;
        this.SEASON = SEASON;
        this.TRIP_ID = TRIP_ID;
        this.DISTANCE = DISTANCE;
        this.MAX_GRP_SIZE = MAX_GRP_SIZE;
    }

    public String getState() {
        return STATE;
    }

    public void setState(String STATE) {
        this.STATE = STATE;
    }

    public String getStartLocation() {
        return START_LOCATION;
    }

    public void setStartLocation(String START_LOCATION) {
        this.START_LOCATION = START_LOCATION;
    }

    public String getTripName() {
        return TRIP_NAME;
    }

    public void setTripName(String TRIP_NAME) {
        this.TRIP_NAME = TRIP_NAME;
    }

    public String getActivity() {
        return ACTIVITY;
    }

    public void setActivity(String ACTIVITY) {
        this.ACTIVITY = ACTIVITY;
    }

    public String getSeason() {
        return SEASON;
    }

    public void setSeason(String SEASON) {
        this.SEASON = SEASON;
    }

    public int getTripID() {
        return TRIP_ID;
    }

    public void setTripID(int TRIP_ID) {
        this.TRIP_ID = TRIP_ID;
    }

    public int getDistance() {
        return DISTANCE;
    }

    public void setDistance(int DISTANCE) {
        this.DISTANCE = DISTANCE;
    }

    public int getMaxGroupSize() {
        return MAX_GRP_SIZE;
    }

    public void setMaxGroupSize(int MAX_GRP_SIZE) {
        this.MAX_GRP_SIZE = MAX_GRP_SIZE;
    }

    @Override
    public String toString() {
        return ("State: " + this.STATE + " | " +
                this.START_LOCATION + " | " +
                this.TRIP_NAME + " | " +
                this.ACTIVITY + " | " +
                this.SEASON + " | " +
                this.TRIP_ID + " | " +
                this.DISTANCE + " | " +
                this.MAX_GRP_SIZE);
    }
}
