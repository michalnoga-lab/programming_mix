package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Scores {

    private List<Player> playersScores = new ArrayList<>();

    public void addManyPlayersToHighScores(List<Player> players) {
        playersScores.addAll(players);
    }

    public void addOnePlayerToHighScores(Player player) {
        playersScores.add(player);
    }
}
