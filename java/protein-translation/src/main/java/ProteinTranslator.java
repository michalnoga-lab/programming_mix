import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProteinTranslator {

    private Map<String, String> translationCodes = Stream.of(new Object[][]{
            {"AUG", "Methionine"},
            {"UUU", "Phenylalanine"},
            {"UUC", "Phenylalanine"},
            {"UUA", "Leucine"},
            {"UUG", "Leucine"},
            {"UCU", "Serine"},
            {"UCC", "Serine"},
            {"UCA", "Serine"},
            {"UCG", "Serine"},
            {"UAU", "Tyrosine"},
            {"UAC", "Tyrosine"},
            {"UGU", "Cysteine"},
            {"UGC", "Cysteine"},
            {"UGG", "Tryptophan"},
            {"UAA", "STOP"},
            {"UAG", "STOP"},
            {"UGA", "STOP"}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

    List<String> translate(String rnaSequence) {
        List<String> translatedList = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String translatedSequence = findCode(rnaSequence.substring(i, i + 3));

            if (!translatedSequence.equals("STOP")) {
                translatedList.add(translatedSequence);
            } else {
                break;
            }
        }
        return translatedList;
    }

    private String findCode(String rna) {
        return translationCodes
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(rna))
                .findFirst()
                .get()
                .getValue();
    }
}