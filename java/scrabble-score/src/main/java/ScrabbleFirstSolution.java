import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScrabbleFirstSolution {
    private String word;
    private Map<Integer, List<Character>> scores = Map.of(
            1, List.of('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
            2, List.of('D', 'G'),
            3, List.of('B', 'C', 'M', 'P'),
            4, List.of('F', 'H', 'V', 'W', 'Y'),
            5, List.of('K'),
            8, List.of('J', 'X'),
            10, List.of('Q', 'Z')
    );

    ScrabbleFirstSolution(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        int[] totalScore = new int[1];

        Stream<Character> characterStream = IntStream.range(0, word.length()).mapToObj(i -> word.charAt(i));

        characterStream
                .forEach(character -> {
                    scores
                            .entrySet()
                            .stream()
                            .filter(value -> value.getValue().contains(character))
                            .forEach(element -> totalScore[0] += element.getKey());
                });

        return totalScore[0];
    }
}

/* The HashMap remove the complexity and able to get element in O(1).
So going through all the HashMap with an EntrySet, defeat its purpose.
*/