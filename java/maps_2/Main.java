import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    private static final String PATH = System.getProperty("user.dir") + "/src/";

    public static void main(String[] args) {
        List<String> sentences = getDataFromFile("sentences");
        Map<String, String> vowelsConsonantsMap = createVowelsConsonantMap(sentences);

        System.out.println("Mapa ma " + findKeysAndValuesEqualLengths(vowelsConsonantsMap) + " kluczy i wartości o tej samej długości.");

        Optional<Integer> biggestDifference = findKeyAndValueBiggestLengthDifference(vowelsConsonantsMap);
        System.out.println(biggestDifference.map(difference -> "Największa różnica w długości klucz wartość wynosi: " + difference)
                .orElse("Brak różnic"));

        Optional<Integer> smallestDifference = findKeyAndValueSmallestLengthDifference(vowelsConsonantsMap);
        System.out.println(smallestDifference.map(difference -> "Najmniejsza różnica w długości klucz wartość wynosi: " + difference)
                .orElse("Brak różnic"));
    }

    private static List<String> getDataFromFile(String fileName) {
        List<String> output = new ArrayList<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(PATH + fileName + ".txt"));
            stream
                    .forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    private static String findVowels(String sentence) {
        return sentence.toLowerCase().replaceAll("[^aeouiy]+", "");
    }

    private static String findConsonants(String sentence) {
        return sentence.toLowerCase()
                .replaceAll("[^a-z]+", "")
                .replaceAll("[aeouiy]+", "");
    }

    private static Map<String, String> createVowelsConsonantMap(List<String> sentences) {
        Map<String, String> output = new HashMap<>();
        sentences
                .forEach(line -> output.put(findVowels(line), findConsonants(line)));
        return output;
    }

    private static long findKeysAndValuesEqualLengths(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getKey().length() == entry.getValue().length())
                .count();
    }

    private static Optional<Integer> findKeyAndValueBiggestLengthDifference(Map<String, String> map) {
        return map
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().length() - entry.getValue().length())
                .map(Math::abs)
                .max(Comparator.comparingInt(value -> value));
    }

    private static Optional<Integer> findKeyAndValueSmallestLengthDifference(Map<String, String> map) {
        return
                map
                        .entrySet()
                        .stream()
                        .map(entry -> entry.getKey().length() - entry.getValue().length())
                        .map(Math::abs)
                        .min(Comparator.comparingInt(value -> value));
    }
}