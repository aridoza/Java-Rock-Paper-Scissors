package com.ga;

public class ComputerPlayer extends Player {

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
