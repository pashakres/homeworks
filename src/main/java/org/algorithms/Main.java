package org.algorithms;

import org.algorithms.utils.PersonGenerator;
import org.algorithms.utils.PersonSearching;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Person> personByHeightComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getHeight() - o2.getHeight();
            }
        };

        Comparator<Person> personByWeightComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        final int NUMBER_OF_PEOPLE = 100000000;
        PersonGenerator pg = new PersonGenerator();

        Person[] people = pg.generate(NUMBER_OF_PEOPLE);

        System.out.println(Arrays.toString(people));

        // Sorting by age
        Arrays.sort(people);
        System.out.println("Sorted by age: " + Arrays.toString(people));

        // Sorting by height
        Arrays.sort(people, personByHeightComparator);
        System.out.println("Sorted by height: " + Arrays.toString(people));

        // Sorting by weight
        Arrays.sort(people, personByWeightComparator);
        System.out.println("Sorted by weight: " + Arrays.toString(people));

        System.out.println("Number of people with same weight and different height" + PersonSearching.sameWeightDiffHeightCount(people));

        // Additional: No, in the best case time complexity will be O(log(n))
    }
}
