package com.x.ufogame;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore {

    File data = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);

    File file = new File(data, "highscore.txt");
    private int highScore = 0;

    public int readHighScore() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                highScore = Integer.parseInt(br.readLine());
                br.close();
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            e.printStackTrace();

        }

        return highScore;
    }

    public void writeHighScore(int highestScore) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(highestScore));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}