package com.app.model;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class ScoresTests {

    @Test
    @Description("Check if many players will be added to High Scores")
    void addManyPlayersToHighScores1() {
        Scores expectedScores = new Scores();
        Player player1 = Player.builder()
                .name("aa")
                .time(LocalDateTime.of(2022, 7, 26, 20, 6))
                .gameDuration(Duration.ofMillis(1000))
                .guessesUsed(5)
                .build();
        Player player2 = Player.builder()
                .name("bb")
                .time(LocalDateTime.of(2022, 7, 26, 20, 20))
                .gameDuration(Duration.ofMillis(1000))
                .guessesUsed(5)
                .build();
        expectedScores.setPlayersScores(List.of(player1, player2));

        Scores actualScores = new Scores();
        actualScores.addManyPlayersToHighScores(List.of(player1, player2));

        Assertions.assertEquals(expectedScores, actualScores);
        Assertions.assertEquals(2, actualScores.getPlayersScores().size());
    }

    @Test
    @Description("Check if player is added to High Scores - no players at all")
    void addOnePlayerToHighScores1() {
        Scores scores = new Scores();

        Assertions.assertEquals(0, scores.getPlayersScores().size());
    }

    @Test
    @Description("Check if player is added to High Scores - no players in High Scores")
    void addOnePlayerToHighScores2() {
        Player player = Player.builder()
                .name("aa")
                .time(LocalDateTime.of(2022, 7, 26, 20, 6))
                .gameDuration(Duration.ofMillis(1000))
                .guessesUsed(5)
                .build();
        Scores expectedScores = new Scores();
        expectedScores.setPlayersScores(List.of(player));

        Scores actualScores = new Scores();
        actualScores.addOnePlayerToHighScores(player);

        Assertions.assertEquals(expectedScores, actualScores);
        Assertions.assertEquals(1, actualScores.getPlayersScores().size());
    }

    @Test
    @Description("Check if player is added to High Scores - one player in High Scores")
    void addOnePlayerToHighScores3() {
        Player player1 = Player.builder()
                .name("aa")
                .time(LocalDateTime.of(2022, 7, 26, 20, 6))
                .gameDuration(Duration.ofMillis(1000))
                .guessesUsed(5)
                .build();
        Player player2 = Player.builder()
                .name("bb")
                .time(LocalDateTime.of(2022, 7, 26, 20, 20))
                .gameDuration(Duration.ofMillis(1000))
                .guessesUsed(5)
                .build();
        Scores expectedScores = new Scores();
        expectedScores.setPlayersScores(List.of(player1, player2));

        Scores actualScores = new Scores();
        actualScores.addOnePlayerToHighScores(player1);
        actualScores.addOnePlayerToHighScores(player2);

        Assertions.assertEquals(expectedScores, actualScores);
        Assertions.assertEquals(2, actualScores.getPlayersScores().size());
    }
}
