package com.ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public abstract class PlayGame {
    public String playGame() {
        return null;
    }

    //HumanVersusComputer gameSetup = new HumanVersusComputer();

    public static String matchResult(Player firstPlayer, Player opponent, String gameMode) {
        int rightAnswers = 0;
        int wrongAnswers = 0;

        Scanner scanner = new Scanner(System.in);

        // case where game is a tie
        if (firstPlayer.getPlayerMove().equals(opponent.getPlayerMove())) {
            // update the player history
            updateHistory(gameMode, firstPlayer, opponent, "TIE");

            System.out.println("Added to player history: " + firstPlayer.getPlayerHistory());

            System.out.println("It's a tie!");

            // handle end of the match
            resetOrQuitOrHistory(scanner, firstPlayer, opponent, gameMode);

            // cases where player beats computer
        } else if (firstPlayer.getPlayerMove().equals("rock") && opponent.getPlayerMove().equals("scissors")
                || firstPlayer.getPlayerMove().equals("paper") && opponent.getPlayerMove().equals("rock")
                || firstPlayer.getPlayerMove().equals("scissors") && opponent.getPlayerMove().equals("paper")) {

            // update the player history
            updateHistory(gameMode, firstPlayer, opponent, "WIN");

            System.out.println("Added to player history: " + firstPlayer.getPlayerHistory());
            firstPlayer.setGamesPlayed(firstPlayer.getGamesPlayed() + 1);
            rightAnswers++;


            if (firstPlayer.getScore() == 0){
                firstPlayer.setScore(firstPlayer.getScore() + rightAnswers);
            } else {
                firstPlayer.setScore((firstPlayer.getScore() + 1));
            }
            System.out.println("You win!");

            // handle end of the match
            resetOrQuitOrHistory(scanner, firstPlayer, opponent, gameMode);
        } else if (firstPlayer.getPlayerMove().equals("rock") && opponent.getPlayerMove().equals("paper")
                || firstPlayer.getPlayerMove().equals("paper") && opponent.getPlayerMove().equals("scissors")
                || firstPlayer.getPlayerMove().equals("scissors") && opponent.getPlayerMove().equals("rock")) {
            // case where computer beats player

            // update the player history
            updateHistory(gameMode, firstPlayer, opponent, "LOST");

            System.out.println("Added to player history: " + firstPlayer.getPlayerHistory());
            firstPlayer.setGamesPlayed(firstPlayer.getGamesPlayed() + 1);
            wrongAnswers++;


            if (firstPlayer.getScore() == 0){
                firstPlayer.setScore(wrongAnswers);
            } else {
                firstPlayer.setScore((firstPlayer.getScore() + 1));
            }
            System.out.println("You lose.");

            // handle end of the match
            resetOrQuitOrHistory(scanner, firstPlayer, opponent, gameMode);

        } else if (!"rock".equals(firstPlayer.getPlayerMove())
                || !"paper".equals(firstPlayer.getPlayerMove())
                || !"scissors".equals(firstPlayer.getPlayerMove())) {
            // record the computer move and player move here to text file for history
            System.out.println("Sorry, that's not a valid input.");

            if (gameMode.equals("computer")) {
                return HumanVersusComputer.onePlayerGame(firstPlayer, new ComputerPlayer(){});
            } else {
                HumanVersusComputer.twoPlayerGame(firstPlayer, opponent);
            }
        }
        return HumanVersusComputer.getGameType();
    }
        public int updateScore(int rightOrWrong) {
            rightOrWrong++;
            return rightOrWrong;
        }

        // update the player's game history based on
        public static void updateHistory(String gameMode, Player player1, Player player2, String result) {
            if (gameMode.equals("2 players")) {
                // update both player's histories
                player1.getPlayerHistory().add(result + ": " + "your move: " + player1.getPlayerMove() + ", opponent move: " + player2.getPlayerMove() + ".");
                player2.getPlayerHistory().add(result + ": " + "your move: " + player2.getPlayerMove() + ", opponent move: " + player1.getPlayerMove() + ".");

            } else if (gameMode.equals("computer")) {
                // update player1 history
                player1.getPlayerHistory().add(result + ": " + "your move: " + player1.getPlayerMove() + ", opponent move: " + player2.getPlayerMove() + ".");
            }
        }

        public static void resetOrQuitOrHistory(Scanner scanner, Player player1, Player player2, String gameType) {
            System.out.println("Play again? Enter Y, or enter N to quit. \nEnter 'history' to see history");

            String userInput = scanner.nextLine().toLowerCase();

            // single player
            if (gameType.equals("computer")) {
                if (userInput.equals("y")) {
                    HumanVersusComputer.onePlayerGame(player1, new ComputerPlayer(){});
                } else if (userInput.equals("n")) {
                    System.exit(0);
                } else if (userInput.equals("history")) {
                    System.out.println("===GAME HISTORY===");
                    player1.getPlayerHistory()
                            .forEach(entry -> System.out.println(entry));
                    if (gameType.equals("computer")) {
                        HumanVersusComputer.onePlayerGame(player1, new ComputerPlayer(){});
                    } else {
                        HumanVersusComputer.twoPlayerGame(player1, player2);
                    }
                } else {
                    resetOrQuitOrHistory(scanner, player1, new ComputerPlayer(){}, "computer");
                }
            } else if (gameType.equals("2 players")) {
                if (userInput.equals("y")) {
                    HumanVersusComputer.twoPlayerGame(player1, player2);
                } else if (userInput.equals("n")) {
                    System.exit(0);
                } else if (userInput.equals("history")) {
                    System.out.println("===GAME HISTORY===");
                    player1.getPlayerHistory()
                            .forEach(entry -> System.out.println(entry));

                    // take player back to main game menu
                    if (gameType.equals("computer")) {
                        HumanVersusComputer.onePlayerGame(player1, new ComputerPlayer(){});
                    } else {
                        HumanVersusComputer.twoPlayerGame(player1, player2);
                    }
                } else {
                    resetOrQuitOrHistory(scanner, player1, player2,"2 players");
                }
            }

            // 2 players


        }
}
