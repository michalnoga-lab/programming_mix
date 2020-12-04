import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private Map<Character, Integer> SCORES = new HashMap<>();
    private String word;

    Scrabble(String word) {
        "AEIOULNRST".chars().forEach(letter -> SCORES.put((char) letter, 1));
        "DG".chars().forEach(letter -> SCORES.put((char) letter, 2));
        "BCMP".chars().forEach(letter -> SCORES.put((char) letter, 3));
        "FHVWY".chars().forEach(letter -> SCORES.put((char) letter, 4));
        "K".chars().forEach(letter -> SCORES.put((char) letter, 5));
        "JX".chars().forEach(letter -> SCORES.put((char) letter, 8));
        "QZ".chars().forEach(letter -> SCORES.put((char) letter, 10));

        this.word = word.toUpperCase();
    }

    int getScore() {
        return word.toUpperCase()
                .chars()
                .mapToObj(letter -> (char) letter)
                .map(SCORES::get)
                .reduce(Integer::sum)
                .orElse(0);
    }
}