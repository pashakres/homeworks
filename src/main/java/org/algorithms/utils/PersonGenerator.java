package org.algorithms.utils;

import org.algorithms.Person;

import java.util.Random;

public class PersonGenerator {
    Random rand;
    public PersonGenerator() {
        rand = new Random();
    }

    private int getRandomInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    /**
     * Generates random age for adult person.
     *
     * @return Random age.
     */
    public int getRandomAge() {
        return getRandomInt(18, 100);
    }

    /**
     * Generates random height for adult person.
     *
     * @return Random height.
     */
    public int getRandomHeight() {
        return getRandomInt(70, 250);
    }

    /**
     * Generates random weight for adult person.
     *
     * @return Random weight.
     */
    public int getRandomWeight() {
        return getRandomInt(30, 200);
    }

    /**
     * Generates a random adult person.
     *
     * @return Random person.
     */
    public Person generate() {
        return new Person(getRandomHeight(),getRandomWeight(), getRandomAge());
    }

    /**
     * Generates array of adult persons of a given length.
     *
     * @param amount Number of people to generate.
     * @return Array of randoms persons.
     */
    public Person[] generate(int amount) {
        Person[] persons = new Person[amount];
        for (int i = 0; i < amount; i++) {
            persons[i] = generate();
        }
        return persons;
    }
}
