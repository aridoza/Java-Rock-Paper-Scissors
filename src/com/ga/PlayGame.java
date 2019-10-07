package com.ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public abstract class PlayGame {
    public abstract String playGame();

    public String matchResult(Player firstPlayer, Player opponent, String gameMode) {
        int rightAnswers = 0;
        int wrongAnswers = 0;

        Scanner scanner = new Scanner(System.in);

        if (firstPlayer.getPlayerMove().equals(opponent.getPlayerMove())) {
            // case where game is a tie
            // update the player history
            updateHistory(gameMode, firstPlayer, opponent);

            System.out.println("It's a tie!");
            resetOrQuit(scanner);
        } else if (firstPlayer.getPlayerMove().equals("rock") && opponent.getPlayerMove().equals("scissors")
                || firstPlayer.getPlayerMove().equals("paper") && opponent.getPlayerMove().equals("rock")
                || firstPlayer.getPlayerMove().equals("scissors") && opponent.getPlayerMove().equals("paper")) {

            // cases where player beats computer
            // update the player history
            updateHistory(gameMode, firstPlayer, opponent);

            System.out.println("Added to player history: " + firstPlayer.getPlayerHistory());
            firstPlayer.setGamesPlayed(firstPlayer.getGamesPlayed() + 1);
            rightAnswers++;


            if (firstPlayer.getScore() == 0){
                firstPlayer.setScore(rightAnswers);
            } else {
                firstPlayer.setScore((firstPlayer.getScore() + 1));
            }
            System.out.println("You win!");
            resetOrQuit(scanner);
        } else if (firstPlayer.getPlayerMove().equals("rock") && opponent.getPlayerMove().equals("paper")
                || firstPlayer.getPlayerMove().equals("paper") && opponent.getPlayerMove().equals("scissors")
                || firstPlayer.getPlayerMove().equals("scissors") && opponent.getPlayerMove().equals("rock")) {
            // case where computer beats player

            // update the player history
            updateHistory(gameMode, firstPlayer, opponent);

            System.out.println("Added to player history: " + firstPlayer.getPlayerHistory());
            firstPlayer.setGamesPlayed(firstPlayer.getGamesPlayed() + 1);
            wrongAnswers++;


            if (firstPlayer.getScore() == 0){
                firstPlayer.setScore(wrongAnswers);
            } else {
                firstPlayer.setScore((firstPlayer.getScore() + 1));
            }
            System.out.println("You lose.");
            resetOrQuit(scanner);

        } else if (!"rock".equals(firstPlayer.getPlayerMove())
                || !"paper".equals(firstPlayer.getPlayerMove())
                || !"scissors".equals(firstPlayer.getPlayerMove())) {
            // record the computer move and player move here to text file for history
            System.out.println("Sorry, that's not a valid input.");
            return playGame();
        }
        return playGame();
    }
        public int updateScore(int rightOrWrong) {
            rightOrWrong++;
            return rightOrWrong;
        }

        public static void updateHistory(String gameMode, Player player1, Player player2) {
            if (gameMode.equals("2 players")) {
                // update both player's histories
                player1.getPlayerHistory().add("Game " + Integer.toString(player1.getGamesPlayed()) + ": " + "your move: " + player1.getPlayerMove() + ", opponent move: " + player2.getPlayerMove() + ".");
                player2.getPlayerHistory().add("Game " + Integer.toString(player2.getGamesPlayed()) + ": " + "your move: " + player2.getPlayerMove() + ", opponent move: " + player1.getPlayerMove() + ".");

            } else if (gameMode.equals("computer")) {
                // update player1 history
                player1.getPlayerHistory().add("Game " + Integer.toString(player1.getGamesPlayed()) + ": " + "your move: " + player1.getPlayerMove() + ", opponent move: " + player2.getPlayerMove() + ".");
            }
        }

        public void resetOrQuit(Scanner scanner) {
            System.out.println("Play again? Enter Y, or enter N to quit.");

            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("y")) {
                playGame();
            } else if (userInput.equals("n")) {
                System.exit(0);
            } else {
                resetOrQuit(scanner);
            }

        }
}
