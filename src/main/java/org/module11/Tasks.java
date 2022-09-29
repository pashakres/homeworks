package org.module11;

import com.codepoetics.protonpack.StreamUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class Tasks {
    /**
     * Метод приймає на вхід список імен. Необхідно вернути рядок вигляду 1. Ivan, 3. Peter...
     * лише з тими іменами, що стоять під непарним індексом (1, 3 і т.д.)
     */
    public String task1(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i+1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    /**
     * Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
     * Повертає список цих рядків у верхньому регістрі, і відсортованих по спадання (від Z до A).
     */
    public List<String> task2(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((str1, str2) -> -str1.compareTo(str2))
                .toList();
    }

    /**
     * Є масив: ["1, 2, 0", "4, 5"]
     * Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому,
     * наприклад: "0, 1, 2, 4, 5"
     */
    public String task3(String[] arr) {
        return Stream.of(arr)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.joining(", "));
    }

    /**
     * Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел, але не використовуючи Stream.iterate.
     * Реалізуйте свій лінійний конгруэнтний генератор. Для цього почніть з x[0] = seed,
     * і далі кожний наступний елемент рахуйте по формулі на зразок
     * x[n + 1] = 1 (a x[n] + c) % m для коректних значень a, c, та m.
     * Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.
     *
     * Для тесту використовуйте такі дані:
     * a = 25214903917
     * c = 11
     * m = 2^48 (2в степені 48`)
     */
    public Stream<Long> task4(Long a, Long c, Long m) {
        Long seed = 0L;
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    /**
     * Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
     * який "перемішує" елементи зі стрімів first та second,
     * зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return StreamUtils.zip(first, second, List::of).flatMap(Collection::stream);
    }

}
