package org.module11;

import java.util.List;
import java.util.stream.Stream;

public class TaskMain {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Alex", "Lissa", "Mikaela", "Luc", "Laurel", "Homer");
        Tasks tasks = new Tasks();
        System.out.println("Task 1: " + tasks.task1(names));
        System.out.println("Task 2: " + tasks.task2(names));

        System.out.println("Task 3: " + tasks.task3(new String[]{"1, 2, 0", "4, 5"}));
        System.out.println("Task 4: " + tasks.task4(25214903917L, 11L, 281474976710656L).limit(10).toList());

        Stream<Integer> first = Stream.of(1,2,3,4,5,6);
        Stream<Integer> second = Stream.of(7,8,9);
        Stream<Integer> third = Tasks.zip(first, second);
        System.out.println("Task 5: " + third.toList());
    }
}
