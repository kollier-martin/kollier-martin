package io.beansprout.CodingChallenges;

import java.util.*;

public class ParallelArray {
    public static void main(String[] args) {
        int arraySize = 3;
        String names = "Malcolm,John,Lucy";
        String heights = "4.2,6.1,2.6";

        System.out.println(sortedNames(arraySize, names, heights));
    }

    public static String sortedNames(int arraySize, String names, String heights) {
        // Convert these String to Lists
        List<String> heightsList = new ArrayList<>(List.of(heights.split(",")));
        List<String> namesList = new ArrayList<>(List.of(names.split(",")));

        // Convert each element of the height list to a list doubles
        List<Double> heightsAsDoubles = new ArrayList<>();
        for (String h : heightsList) {
            heightsAsDoubles.add(Double.valueOf(h));
        }

        // Map them to relate
        Map<String, Double> namesHeights = new HashMap<>();
        for (int i = 0; i < arraySize; i++) {
            namesHeights.put(namesList.get(i), heightsAsDoubles.get(i));
        }

        // Sort map then return the keys as a String
        List<Map.Entry<String, Double>> list = new ArrayList<>(namesHeights.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        StringBuilder newNames = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            if (i == (arraySize - 1)) {
                newNames.append(list.get(i).getKey());
            } else {
                newNames.append(list.get(i).getKey()).append(",");
            }
        }

        return newNames.toString();
    }
}