import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = generateNumbersList(20);
        Map<Integer, Integer> numbersMap = generateNumbersMap(numbers);

        Optional<Integer> biggestPairValue = findBiggestPairValue(numbersMap);
        System.out.println(biggestPairValue.map(integer -> "Największa suma klucz + wartość to: " + integer).orElse("BRAK"));

        Optional<Integer> biggestKey = findBiggestKey(numbersMap);
        System.out.println(biggestKey.map(integer -> "Najwięszka wartość klucza: " + integer).orElse("BRAK"));

        Optional<Integer> smallestKey = findSmallestKey(numbersMap);
        System.out.println(smallestKey.map(integer -> "Najmniejsza wartość klucza: " + integer).orElse("BRAK"));

        Map<Integer, Integer> numbersMapSortedByKeys = sortByKey(numbersMap);
        System.out.println(numbersMapSortedByKeys);

        Map<Integer, Integer> numbersMapSortedByValue = sortByValue(numbersMap);
        System.out.println(numbersMapSortedByValue);
    }

    private static Integer generateNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to + 1 - from) + from);
    }

    private static Set<Integer> generateNumbersList(int howMany) {
        Set<Integer> output = new HashSet<>();
        while (output.size() < howMany + 1) {
            output.add(generateNumber(10, 30));
        }
        return output;
    }

    private static Map<Integer, Integer> generateNumbersMap(Set<Integer> numbers) {
        return numbers
                .stream()
                .collect(Collectors.toMap(num -> num, Main::sumEvenDigits));
    }

    private static Integer sumEvenDigits(int number) {
        String[] numberArray = String.valueOf(number).split("");
        int sum = 0;

        for (String s : numberArray) {
            int n = Integer.parseInt(s);
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

    private static Optional<Integer> findBiggestPairValue(Map<Integer, Integer> numbersMap) {

        return numbersMap
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + entry.getValue())
                .max(Comparator.comparingInt(value -> value));
    }

    private static Optional<Integer> findBiggestKey(Map<Integer, Integer> numbersMap) {
        return numbersMap
                .keySet()
                .stream()
                .max(Comparator.comparingInt(value -> value));
    }

    private static Optional<Integer> findSmallestKey(Map<Integer, Integer> numbersMap) {
        return numbersMap
                .keySet()
                .stream()
                .min(Comparator.comparingInt(value -> value));
    }

    private static Map<Integer, Integer> sortByKey(Map<Integer, Integer> numbersMap) {
        return numbersMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> numbersMap) {
        return numbersMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }
}