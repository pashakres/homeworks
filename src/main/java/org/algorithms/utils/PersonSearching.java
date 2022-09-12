package org.algorithms.utils;

import org.algorithms.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonSearching {
    /**
     * Finds number of people with same weight and different height
     * with time complexity O(n).
     *
     * @param people Array of persons.
     * @return number of people with same weight and different height.
     */
    public static int sameWeightDiffHeightCount(Person[] people) {
        // HashMap get and put methods time complexity = O(1)
        // Therefore time complexity (n * O(1) * O(1)) = O(n)
        Map<Integer, Map<Integer, Boolean>> heightsPerWeightMap = new HashMap<>();

        for (Person person: people) {
            if (heightsPerWeightMap.containsKey(person.getWeight())) {
                Map<Integer, Boolean> heightMap = heightsPerWeightMap.get(person.getWeight());
                if (!heightMap.containsKey(person.getHeight())) {
                    heightMap.put(person.getHeight(), true);
                }
            } else {
                Map<Integer, Boolean> heightMap = new HashMap<>();
                heightMap.put(person.getHeight(), true);
                heightsPerWeightMap.put(person.getWeight(), heightMap);
            }
        }

        int count = 0;
        for (Map<Integer, Boolean> nestedMap: heightsPerWeightMap.values()) {
            count += nestedMap.size();
        }

        return count;
    }
}
