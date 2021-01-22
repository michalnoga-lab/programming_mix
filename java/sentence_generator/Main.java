import java.util.*;

public class Main {
    public static void main(String[] args) {

        int sentenceLength = generateNumber(10, 41);
        int maxLetterOccurrence = generateNumber(1, 4);

        String sentence = generateSentence(sentenceLength, maxLetterOccurrence);
        System.out.println("Wygenerowano napis: " + sentence);

        Optional<String> characterWithBiggestDistance = findCharacterWithBiggestDistance(sentence);
        System.out.println(characterWithBiggestDistance.map(ch -> "Największa odległość pomiędzy wystąpieniami ma litera: " + ch)
                .orElse("BRAK"));

        Optional<Integer> characterWithSmallestDistanceToFirstPosition = findCharacterWithSmallestDistanceToFirstPosition(sentence, 'A');
        System.out.println(characterWithSmallestDistanceToFirstPosition.map(ch -> "Najmniejszą odległość do początku wyrazu dla litery: A wynosi " + ch)
                .orElse("BRAK"));

        String symmetricSentence = generateSymmetricalSentence(sentence);
        System.out.println("Wygenrowano: " + symmetricSentence);
    }

    private static int generateNumber(int from, int to) {
        return (int) Math.floor(Math.random() * (to - from) + from);
    }

    private static String generateSentence(int sentenceLength, int maxLetterOccurrence) {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.toString().length() < sentenceLength) {
            char character = (char) generateNumber(65, 91);

            if (stringBuilder.toString().length() -
                    stringBuilder.toString().replaceAll(String.valueOf(character), "").length() < maxLetterOccurrence) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    private static Optional<String> findCharacterWithBiggestDistance(String sentence) {
        Map<String, Integer> distances = new HashMap<>();

        Arrays.stream(sentence.split(""))
                .forEach(character -> {
                    List<Integer> indexes = new ArrayList<>();

                    int index = sentence.indexOf(character);
                    while (index > 0) {
                        indexes.add(index);
                        index = sentence.indexOf(character, index + 1);
                    }
                    int distance = 0;
                    if (indexes.size() == 3) {
                        distance = distance + indexes.get(2) - indexes.get(1);
                        distance = distance + indexes.get(1) - indexes.get(0);
                    } else if (indexes.size() == 2) {
                        distance = distance + indexes.get(1) - indexes.get(0);
                    }
                    distances.put(character, distance);
                });
        System.out.println("Poszczególne odległości:");
        distances
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(pair -> System.out.println(pair.getKey() + " : " + pair.getValue()));

        return distances
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst()
                .map(Map.Entry::getKey);
    }


    private static Optional<Integer> findCharacterWithSmallestDistanceToFirstPosition(String sentence, char characterToCheck) {
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.split("")[i].equals(String.valueOf(characterToCheck))) {
                positions.add(i);
            }
        }
        return positions.stream().reduce(Integer::sum);
    }

    private static String generateSymmetricalSentence(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] sentenceArray = sentence.toCharArray();

        for (int i = 0; i < sentenceArray.length; i++) {
            int difference = 90 - (int) (sentenceArray[i]);
            stringBuilder.append((char) (65 + difference));
        }
        return stringBuilder.toString();
    }
}