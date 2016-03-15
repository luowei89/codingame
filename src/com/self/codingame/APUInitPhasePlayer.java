package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class APUInitPhasePlayer {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        boolean[][] board = new boolean[width][height];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                board[j][i] = c == '0';
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j]) {
                    StringBuffer sb = new StringBuffer();
                    int k = 1;
                    sb.append(i + " " + j);
                    while (i + k < width) {
                        if (board[i + k][j]) {
                            sb.append(" " + (i + k) + " " + j);
                            break;
                        }
                        k++;
                    }
                    if (i + k >= width) {
                        sb.append(" -1 -1");
                    }
                    k = 1;
                    while (j + k < height) {
                        if (board[i][j + k]) {
                            sb.append(" " + i + " " + (j + k));
                            break;
                        }
                        k++;
                    }
                    if (j + k >= height) {
                        sb.append(" -1 -1");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
        // System.out.println("0 0 1 0 0 1"); // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}
