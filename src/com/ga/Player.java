package com.ga;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Player {
    private String playerName;
    private int score;
    private int gamesPlayed = 1;
    private String playerMove;
    private ArrayList<String> playerHistory = new ArrayList<>();

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public ArrayList<String> getPlayerHistory() {
        return playerHistory;
    }


    public String generateMove() {
        int randomNum = (int) Math.floor(Math.random() * 10);

        if (randomNum <= 3) {
            return "rock";
        } else if (randomNum > 3 && randomNum <= 6) {
            return "paper";
        } else {
            return "scissors";
        }
    }
}
