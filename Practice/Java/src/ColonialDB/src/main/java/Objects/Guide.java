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

import static Constants.ApplicationConstants.EMPTY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
    private String guideNum, lastName, address, firstName,
            city, state, postalCode, phoneNum, hireDate = EMPTY;

    @Override
    public String toString() {
        return JsonMapperUtil.objectToJson(this);
    }
}
