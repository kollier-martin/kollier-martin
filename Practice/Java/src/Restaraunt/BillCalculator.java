package io.beansprout.Restaraunt;

public class BillCalculator {
    private BillCalculator() throws IllegalAccessException {
        throw new IllegalAccessException("BillCalculator class is not to be instantiated.");
    }

    /**
     * Calculate the total for the receipt, accounts for gratuity if applicable
     *
     * @param numOfCustomers Number of customers for the meal
     * @param billAmt        Total for the meal
     * @return Total price
     */
    public static float calculateTotal(int numOfCustomers, int billAmt) {
        if (numOfCustomers >= 6) {
            return (float) ((0.18 * billAmt) + billAmt);
        } else {
            return billAmt;
        }
    }

    /**
     * Calculate the total for the receipt with a discount, accounts for gratuity if applicable
     *
     * @param numOfCustomers Number of customers for the meal
     * @param billAmt        Total for the meal
     * @param discount       Integer used in calculations for applying discounts
     * @return Total price
     */
    public static float calculateTotalWithDiscount(int numOfCustomers, int billAmt, double discount) {
        if (numOfCustomers >= 6) {
            return (float) (0.18 * (billAmt * (discount / 100)) + (billAmt * (discount / 100)));
        } else {
            return (float) (billAmt * (discount / 100));
        }
    }
}