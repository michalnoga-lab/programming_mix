import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> data = getDataFromFile("example_data.csv");
        List<String> dataByVowelsReversed = data
                .stream()
                .sorted(Comparator.comparing(sentence -> countVowels(sentence), Comparator.reverseOrder()))
                .collect(Collectors.toList());
        printElementsShorterThan(15, dataByVowelsReversed);
    }


    private static List<String> getDataFromFile(String fileName) {
        List<String> output = new ArrayList<>();
        final String REGEX = "[A-Z\s]+";

        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "/src/KM_KOLEKCJE_LISTY1/" + fileName))) {

            stream
                    .map(line -> line.split(",")[2])
                    .filter(word -> {
                        List<String> elements = List.of(word.split("\s"));
                        return word.replaceAll(",", "").matches(REGEX) && elements.size() < 3;
                    })
                    .forEach(output::add);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    private static int countVowels(String word) {
        final String VOWELS_REGEX = "[aeouyi]";
        return word.length() - word.toLowerCase().replaceAll(VOWELS_REGEX, "").length();
    }

    private static void printElementsShorterThan(int maxSize, List<String> listToDisplay) {
        listToDisplay
                .stream()
                .filter(line -> line.replaceAll("\s", "").length() <= maxSize)
                .forEach(System.out::println);
    }
}