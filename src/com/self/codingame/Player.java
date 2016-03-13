package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Skynet: the Virus
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            addToList(adjList, N1, N2);
            addToList(adjList, N2, N1);
        }
        Set<Integer> gateways = new HashSet<>();
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(bfSearch(SI, adjList, gateways)); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }

    public static void addToList(Map<Integer, List<Integer>> adjList, Integer n1, Integer n2) {
        List<Integer> list = adjList.get(n1);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(n2);
        adjList.put(n1, list);
    }

    public static void removeFromList(Map<Integer, List<Integer>> adjList, Integer n1, Integer n2) {
        adjList.get(n1).remove(n2);
        adjList.get(n2).remove(n1);
    }

    public static String bfSearch(int start, Map<Integer, List<Integer>> adjList, Set<Integer> gateways) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> explored = new HashSet<>();
        queue.add(start);
        explored.add(start);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> list = adjList.get(node);
            if (list != null) {
                for (int x : list) {
                    if (gateways.contains(x)) {
                        removeFromList(adjList, node, x);
                        return node + " " + x;
                    } else if (!explored.contains(x)) {
                        queue.add(x);
                    }
                }
            }
        }
        return "";
    }
}