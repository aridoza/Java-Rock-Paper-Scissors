package com.ga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements FileAccessor {
    @Override
    public void accessFile(String fileName, Player player) throws IOException {
        File textFile = new File(fileName);

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(textFile));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                if (currentLine.equals(player.getPlayerName())) {
                    // if the player has a history,
                    // loop through their games and store it
                    // in the player object
                    System.out.println("Player found - save history");
                    // player will enter their username;
                    // call this method just after they do and
                    // grab their history if it exists

                }
            }
        } finally {
            reader.close();
        }
    }
}
