package com.app.tools;

import com.app.model.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

    private final String WORDS_PATH = PathsHandler.getWordsPath();
    private final String SCORES_PATH = PathsHandler.getScoresPath();

    public List<String> getWordsFileContent() {
        List<String> words = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(WORDS_PATH))) {

            stream.forEach(words::add);

        } catch (Exception e) {
            System.out.println("Word list file not found!");
        }

        return words;
    }

    public void saveUserScoreToFile(String username, LocalDateTime time, Duration gameDuration, Integer guessesUsed) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(SCORES_PATH, true)) {

            String stringBuilder = username +
                    ";" +
                    time +
                    ";" +
                    gameDuration +
                    ";" +
                    guessesUsed +
                    "\n";

            fileOutputStream.write(stringBuilder.getBytes());
        } catch (Exception e) {
            System.out.println("Error writing scores to file");
        }
    }

    public List<Player> getScoresFileContent() {
        List<Player> players = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(SCORES_PATH)) {

            byte[] fileContent = fileInputStream.readAllBytes();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            players = new ArrayList<>(List.of(new String(fileContent, StandardCharsets.UTF_8).split("\n")))
                    .stream()
                    .map(line -> Player
                            .builder()
                            .name(line.split(";")[0])
                            .time(LocalDateTime.parse((line.split(";")[1])))
                            .gameDuration(Duration.parse((line.split(";")[2])))
                            .guessesUsed(Integer.valueOf(line.split(";")[3]))
                            .build())
                    .toList()
                    .stream()
                    .sorted(Comparator.comparing(Player::getGuessesUsed))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("Error reading best scores from file");
        }
        return players;
    }
}
