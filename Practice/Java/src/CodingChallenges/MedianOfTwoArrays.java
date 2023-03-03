package CodingChallenges;

import java.util.Arrays;
import java.util.HashSet;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(doThings(nums1, nums2));
    }

    public static double doThings(int[] nums1, int[] nums2) {
        int[] combined = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, combined, nums1.length, nums2.length);

        Arrays.sort(combined);
        int length = combined.length;

        // Do Median Math
        if (length % 2 == 0) {
            // Divide length by 2, fetch the number from that index, add it to the number next to it, then divide by two
            return (double) (combined[(length / 2) - 1] + combined[(length / 2)]) / 2;
        } else {
            // There is one number in the middle, return it (Divide by two)
            return (combined[length / 2]);
        }
    }

    public static double doForNoneDupes(int[] nums1, int[] nums2) {
        // Combine both arrays with no duplicates
        HashSet<Double> combinedArray = new HashSet<>();
        for (double j : nums1) {
            combinedArray.add(j);
        }

        for (double n : nums2) {
            combinedArray.add(n);
        }

        // Convert set to array and get length
        Double[] combined = combinedArray.toArray(new Double[0]);
        Arrays.sort(combined);
        int length = combined.length;

        // Do Median Math
        if (length % 2 == 0) {
            // Divide length by 2, fetch the number from that index, add it to the number next to it, then divide by two
            return (combined[(length / 2) - 1] + combined[(length / 2)]) / 2;

            // combined[1] + combined[2]
        } else {
            // There is one number in the middle, return it (Divide by two)
            return (combined[length / 2]);
        }
    }
}
