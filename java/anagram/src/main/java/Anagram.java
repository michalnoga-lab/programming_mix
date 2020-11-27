import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

    String testPhrase;

    public Anagram(String phrase) {
        testPhrase = phrase;
    }

    public List<String> match(List<String> anagramCandidates) {
        List<String> matching = new ArrayList<>();

        anagramCandidates
                .forEach(candidate -> {

                    if (!testPhrase.toLowerCase().equals(candidate.toLowerCase())
                            && toChars(testPhrase).equals(toChars(candidate))) {
                        matching.add(candidate);
                    }
                });
        return matching;
    }

    private List<Character> toChars(String word) {
        return word.toLowerCase().chars().mapToObj(c -> (char) c)
                .sorted(Comparator.comparing(Function.identity()))
                .collect(Collectors.toList());
    }
}