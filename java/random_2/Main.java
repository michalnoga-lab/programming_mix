import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int first = generateNumber(5, 231);
        int second = generateNumber(5, 231);
        int third = generateNumber(5, 231);

        System.out.println("Wylosowano liczbę: " + first);
        System.out.println("Wylosowano liczbę: " + second);
        System.out.println("Wylosowano liczbę: " + third);

        System.out.println("Największa z wylosowanych liczb to: " + findBiggestNumber(first, second, third));
        System.out.println("Najmniejsza z wylosowanych liczb to: " + findSmallestNumber(first, second, third));

        System.out.println("Srednia wynosi: " + calculateAverage(first, second, third));
    }

    private static int generateNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from) + from);
    }

    private static int findBiggestNumber(int first, int second, int third) {
        return List.of(first, second, third)
                .stream()
                .reduce((value1, value2) -> value1 > value2 ? value1 : value2)
                .get();
    }

    private static int findSmallestNumber(int first, int second, int third) {
        return List.of(first, second, third)
                .stream()
                .reduce((value1, value2) -> value1 < value2 ? value1 : value2)
                .get();
    }

    private static int findMiddleNumber(int first, int second, int third) {
        return first + second + third - findBiggestNumber(first, second, third) - findSmallestNumber(first, second, third);
    }

    private static double calculateAverage(int first, int second, int third) {
        String[] biggestArray = String.valueOf(findBiggestNumber(first, second, third)).split("");
        String[] smallestArray = String.valueOf(findSmallestNumber(first, second, third)).split("");

        return (findMiddleNumber(first, second, third) +
                Integer.parseInt(biggestArray[biggestArray.length - 1]) + Integer.parseInt(smallestArray[smallestArray.length - 1])) * 0.5;
    }
}