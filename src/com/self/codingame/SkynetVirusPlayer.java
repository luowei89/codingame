package com.self.codingame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Skynet: the Virus
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SkynetVirusPlayer {

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

        arrangeAdjList(adjList);

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
        queue.add(start);
        queue.add(null);
        Map<Integer, Integer> paths = new HashMap<>();
        paths.put(start, null);
        Map<Integer, String> candidates = new HashMap<>();
        while (queue.size() > 1) {
            Integer node = queue.poll();
            if (node == null) {
                if (!candidates.isEmpty()) {
                    int maxLinks = -1;
                    String bestCandidate = "";
                    for (int key : candidates.keySet()) {
                        List<Integer> linksList = adjList.get(key);
                        int links = linksList == null ? 0 : linksList.size();
                        if (links > maxLinks) {
                            maxLinks = links;
                            bestCandidate = candidates.get(key);
                        }
                    }
                    String[] nodes = bestCandidate.split(" ");
                    removeFromList(adjList, Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]));
                    return bestCandidate;
                }
                queue.add(null);
            } else {
                List<Integer> list = adjList.get(node);
                Integer path = paths.get(node);
                if (list != null) {
                    for (int x : list) {
                        int current = path == null ? x : path;
                        if (gateways.contains(x) && !candidates.containsKey(x)) {
                            candidates.put(x, start + " " + current);
                        }
                        if (!paths.containsKey(x)) {
                            queue.add(x);
                            paths.put(x, current);
                        }
                    }
                }
            }
        }
        return "";
    }

    public static void arrangeAdjList(Map<Integer, List<Integer>> adjList) {
        for (int key : adjList.keySet()) {
            List<Integer> list = adjList.get(key);
            List<Integer> newList = arrangeList(list, adjList);
            adjList.put(key, newList);
        }
    }

    public static List<Integer> arrangeList(List<Integer> list, Map<Integer, List<Integer>> adjList) {
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        List<Integer> newList = new ArrayList<>();
        for (int node : list) {
            List<Integer> linkList = adjList.get(node);
            int links = linkList== null ? 0 : linkList.size();
            pQueue.add(new Node(node, links));
        }
        while (!pQueue.isEmpty()) {
            newList.add(pQueue.poll().getId());
        }
        return newList;
    }

    public static class Node implements Comparable {
        private int id;
        private int links;

        public Node(int id, int links) {
            this.id = id;
            this.links = links;
        }

        @Override
        public int compareTo(Object o) {
            return ((Node)o).getLinks() - this.links;
        }

        public int getId() {
            return id;
        }

        public int getLinks() {
            return links;
        }
    }
}