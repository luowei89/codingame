package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class PowerThorPlayer {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        int xMove = lightX - initialTX;
        int yMove = lightY - initialTY;
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            StringBuffer sb = new StringBuffer();
            if (xMove > 0 && yMove > 0) {
                sb.append("SE");
                xMove--;
                yMove--;
            } else if (xMove > 0 && yMove < 0) {
                sb.append("NE");
                xMove--;
                yMove++;
            } else if (xMove < 0 && yMove > 0) {
                sb.append("SW");
                xMove++;
                yMove--;
            } else if (xMove < 0 && yMove < 0) {
                sb.append("NW");
                xMove++;
                yMove++;
            } else if (xMove > 0) {
                sb.append("E");
                xMove--;
            } else if (yMove > 0) {
                sb.append("S");
                yMove--;
            } else if (xMove < 0) {
                sb.append("W");
                xMove++;
            } else if (yMove < 0) {
                sb.append("N");
                yMove++;
            }

            System.out.println(sb.toString()); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}
