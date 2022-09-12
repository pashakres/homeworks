package org.algorithms;

/**
 * something...
 */
public class Person implements Comparable<Person> {
    private int height;
    private int weight;
    private int age;

    /**
     * Constructor
     *
     * @param height Value of person height in centimeters.
     * @param weight Value of person weight in kilograms.
     * @param age Value of person age in years.
     */
    public Person(int height, int weight, int age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return getAge() - o.getAge();
    }

}
