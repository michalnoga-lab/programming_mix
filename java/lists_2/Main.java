import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = generateIntegersList();
        List<String> words = List.of("RAZ", "DWA", "TRZY", "CZTERY", "PIEC", "SZESC", "SIEDEM", "OSIEM", "DZIEIWEC");
        List<Integer> numbersPrime = new ArrayList<>(new ArrayList<>(numbers
                .stream()
                .filter(num -> isPrime(num))
                .collect(Collectors.toSet())));
        List<String> numbersPrimeTranslated = transformNumbersToStrings(numbersPrime, words);
        saveDataToFile(numbersPrimeTranslated, "output");

        System.out.println("Wszystkie liczby: " + numbers);
        System.out.println("Liczby pierwsze: " + numbersPrime);
        System.out.println("Liczby w zapisie słownym: " + numbersPrimeTranslated);
    }

    private static Integer generateNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from) + from);
    }

    private static List<Integer> generateIntegersList() {
        List<Integer> output = new ArrayList<>();
        int howManyIntegers = generateNumber(10, 100);
        for (int i = 0; i < howManyIntegers; i++) {
            output.add(generateNumber(10, 100));
        }
        return output;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int findBiggerDigit(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::parseInt)
                .reduce((n1, n2) -> n1 > n2 ? n1 : n2)
                .get();
    }

    private static List<String> transformNumbersToStrings(List<Integer> numbers, List<String> words) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            output.add(words.get(findBiggerDigit(numbers.get(i)) - 1));
        }
        return output;
    }

    private static void saveDataToFile(List<String> data, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        data
                .forEach(word -> stringBuilder.append(word).append(","));
        try {
            FileOutputStream stream = new FileOutputStream(System.getProperty("user.dir") + "/" + fileName);
            byte[] bytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
            stream.write(bytes);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}