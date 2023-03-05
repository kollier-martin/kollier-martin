package Objects;

import Utils.JsonMapperUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    private String state, startLocation, tripName, activity, season;
    private int tripId, distance, maxGroupSize;

    @Override
    public String toString() {
        return JsonMapperUtil.objectToJson(this);
    }
}
