import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\java\\";

    public static void main(String[] args) {
        Map<String, String> allMessages = getMessagesFromFile("messages");
        Map<String, Boolean> validatedSentences = validateSentences(allMessages);
        
        writeToFile("output", new ArrayList<>(validatedSentences.keySet()));
    }

    private static Map<String, String> getMessagesFromFile(String fileName) {
        Map<String, String> output = new HashMap<>();

        try {
            Stream<String> stream = Files.lines(Paths.get(PATH + fileName + ".csv"));

            stream
                    .forEach(line -> {
                        String[] lineSplit = line.split(";");
                        output.put(lineSplit[1], lineSplit[2]);
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    private static Map<String, Boolean> validateSentences(Map<String, String> map) {
        return map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().contains(entry.getKey()),
                        (v1, v2) -> v1,
                        HashMap::new
                ))
                .entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> true,
                        (v1, v2) -> v1,
                        HashMap::new
                ));
    }

    private static void writeToFile(String fileName, List<String> messages) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH + fileName);
            messages
                    .forEach(message -> stringBuilder.append(message).append("\n"));
            byte[] bytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}