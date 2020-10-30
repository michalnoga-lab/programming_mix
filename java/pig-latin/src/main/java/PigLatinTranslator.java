import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    String translate(String phrase) {

        List<String> words = Arrays.asList(phrase.split("\\s"));
        StringBuilder stringBuilder = new StringBuilder();

        words
                .stream()
                .map(this::translateWord)
                .forEach(s -> stringBuilder.append(s).append(" "));

        return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
    }

    private String translateWord(String phrase) {
        if (phrase.substring(0, 1).toLowerCase().matches("[aoeuiy]")) {
            if (phrase.startsWith("yt")) {
                return phrase + "ay";
            } else if (phrase.startsWith("y")) {
                return phrase.substring(1) + phrase.substring(0, 1) + "ay";
            } else {
                return phrase + "ay";
            }
        } else {
            if (phrase.length() == 2 && phrase.substring(1, 2).matches("y")) {
                return phrase.substring(1) + phrase.substring(0, 1) + "ay";
            } else if (phrase.substring(1, 3).toLowerCase().matches("qu")
                    || phrase.substring(0, 3).toLowerCase().matches("(thr)|(sch)")) {
                return phrase.substring(3) + phrase.substring(0, 3) + "ay";
            } else if (phrase.substring(0, 2).matches("(ch)|(qu)|(th)|(rh)")) {
                return phrase.substring(2) + phrase.substring(0, 2) + "ay";
            } else if (phrase.contains("y")) {
                return phrase + "ay";
            } else {
                return phrase.substring(1) + phrase.substring(0, 1) + "ay";
            }
        }
    }
}