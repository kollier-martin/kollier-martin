/*
 * Class to represent the Guide Table from OracleColonial table
 *
 */

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
public class TripGuides {
    private int TRIP_ID;
    private String GUIDE_NUM;

    @Override
    public String toString() {
        return JsonMapperUtil.objectToJson(this);
    }
}
