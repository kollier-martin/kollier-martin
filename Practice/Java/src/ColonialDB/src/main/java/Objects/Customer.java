/*
 * Class to represent the Customer Table from OracleColonial table
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
public class Customer {
    private String customerNum, lastName, address, firstName,
            city, state, postalCode, phone = EMPTY;

    @Override
    public String toString() {
        return JsonMapperUtil.objectToJson(this);
    }
}
