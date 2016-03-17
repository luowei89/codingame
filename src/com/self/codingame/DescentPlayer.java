package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class DescentPlayer {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // game loop
        while (true) {
            int maxIndex = -1;
            int maxH = Integer.MIN_VALUE;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain, from 9 to 0.
                if (mountainH > maxH) {
                    maxIndex = i;
                    maxH = mountainH;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(maxIndex); // The number of the mountain to fire on.
        }
    }
}
