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
public class Reservation {
    private String reservationId, customerNum, tripDate;
    private int tripId, numPersons;
    private float tripPrice, otherFees;

    @Override
    public String toString() {
        return JsonMapperUtil.objectToJson(this);
    }
}
