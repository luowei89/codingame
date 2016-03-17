package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class ASCIIArtSolution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        Map<Character, List<Character>> charMap = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            charMap.put(c, new ArrayList<>());
        }
        charMap.put('?', new ArrayList<>());
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < ROW.length(); j++) {
                char c = (char)(j / L + (int)'A');
                if (c <= 'Z' && c >= 'A') {
                    charMap.get(c).add(ROW.charAt(j));
                } else {
                    charMap.get('?').add(ROW.charAt(j));
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        StringBuffer[] sbs = new StringBuffer[H];
        for (int i = 0; i < H; i++) {
            sbs[i] = new StringBuffer();
        }
        for (char x : T.toCharArray()) {
            List<Character> chars = charMap.get(x);
            if (chars == null) {
                chars = charMap.get((char)(x-'a'+'A'));
            }
            if (chars == null) {
                chars = charMap.get('?');
            }
            for (int i = 0; i < chars.size(); i++) {
                sbs[i/L].append(chars.get(i));
            }
        }
        for (int i = 0; i < H; i++) {
            System.out.println(sbs[i].toString());
        }
        // System.out.println("answer");
    }
}
