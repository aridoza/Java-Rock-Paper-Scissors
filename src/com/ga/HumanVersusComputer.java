package com.ga;

import java.util.Scanner;

public class HumanVersusComputer extends PlayGame{

    @Override
    public String playGame() {

        int rightAnswers = 0;
        int wrongAnswers = 0;

        // create a new scanner instance to get player input
        Scanner scanner = new Scanner(System.in);

        // first ask player if they want to play 2 players or
        // against the computer
        System.out.println("Main Menu " +
                "\nEnter game mode (vs computer or 2 players)");

        // stores the game mode selected
        String gameMode = scanner.nextLine().toLowerCase();

        if (gameMode.equals("2 players")) {
            // 2 player mode
            Player firstPlayer = new Player(){};
            Player secondPlayer = new Player(){};

            System.out.println("enter player 1 name:");
            firstPlayer.setPlayerName(scanner.nextLine().toLowerCase());

            System.out.println("enter player 2 name:");
            secondPlayer.setPlayerName(scanner.nextLine().toLowerCase());

            // get first player input
            System.out.println("Type 'rock', 'paper', or 'scissors' to play. " +
                    "\nType 'quit' to exit the game.");

            // store the first player's input
            firstPlayer.setPlayerMove(scanner.nextLine().toLowerCase());
            System.out.println("First player input: " + firstPlayer.getPlayerMove());

            // get second player input
            System.out.println("Type 'rock', 'paper', or 'scissors' to play. " +
                    "\nType 'quit' to exit the game.");

            // store the second player's input
            secondPlayer.setPlayerMove(scanner.nextLine().toLowerCase());
            System.out.println("Second player input: " + secondPlayer.getPlayerMove());

            // quit the game if player says so
            if (firstPlayer.getPlayerMove().equals("quit") || secondPlayer.getPlayerMove().equals("quit")) {
                System.out.println("Exiting game...");
                System.exit(0);
            }

            // compare both player's moves
            return matchResult(firstPlayer, secondPlayer, gameMode);
        } else if (gameMode.equals("computer")) {
            // vs computer

            // create an instance for the computer
            Player computer = new Player(){};

            // create a new player instance for the human
            Player humanPlayer = new Player() {};

            System.out.println("Please enter your name:");
            humanPlayer.setPlayerName(scanner.nextLine());

            // check if player already has a save file: if so get their score
            // if not, initialize it to 0;
            humanPlayer.setScore(0);

            // set game up accordingly
            System.out.println("Type 'rock', 'paper', or 'scissors' to play. " +
                    "\nType 'quit' to exit the game.");

            // store the player's input
            humanPlayer.setPlayerMove(scanner.nextLine().toLowerCase());
            System.out.println("Human player input: " + humanPlayer.getPlayerMove());

            // quit the game if player says so
            if (humanPlayer.getPlayerMove().equals("quit")) {
                System.out.println("Exiting game...");
                System.exit(0);
            }

            computer.setPlayerMove(computer.generateMove());
            System.out.println("computer move: " + computer.getPlayerMove());

            // compare the player's move to the computer's move
            return matchResult(humanPlayer, computer, gameMode);
        } else {
            System.out.println("Sorry that mode is not supported.");
            // restart the game
            playGame();
        }

        // set game up accordingly
        System.out.println("Type 'rock', 'paper', or 'scissors' to play. " +
                "\nType 'quit' to exit the game.");

        // store the player's input
        humanPlayer.setPlayerMove(scanner.nextLine().toLowerCase());
        System.out.println("Human player input: " + humanPlayer.getPlayerMove());

        // quit the game if player says so
        if (humanPlayer.getPlayerMove().equals("quit")) {
            System.out.println("Exiting game...");
            System.exit(0);
        }

        computer.setPlayerMove(computer.generateMove());

        // compare the player's move to the computer's move
        return matchResult(humanPlayer, computer, gameMode);

    }
}
