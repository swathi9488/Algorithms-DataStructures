package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        Vertex v3 = new Vertex("c");
        Vertex v4 = new Vertex("d");
        Vertex v5 = new Vertex("e");
        Map<Vertex, List<Vertex>> undirectedAdjacencyList = new HashMap<Vertex, List<Vertex>>() {{
            put(v1, Arrays.asList(v2, v3));
            put(v2, Arrays.asList(v3));
            put(v3, Arrays.asList( v2));
            put(v4, Arrays.asList(v5));
            put(v5, Arrays.asList(v4));
        }};

        // 1. Label vertices in the order visited
        List<Vertex> orderFirstVisited = new ArrayList<>();

        // 2. Label vertices in the order finished
        List<Vertex> orderFirstFinished = new ArrayList<>();

        // 3. count number of connected components in an undirected graph
        int components = 0;

        //4. detect cycle in cyclic graph
        Set<Boolean> isCycle = new HashSet<>();

        // 5. Detect cycle in an undirected graph
        // key is the child and value is its immediate parent (used for detection of cycle)
        Map<Vertex, Vertex> parentMap = new HashMap<>();
        Map<Vertex, List<Vertex>> directedAdjacencyList = new HashMap<Vertex, List<Vertex>>();
        directedAdjacencyList.put(v1, Arrays.asList(v2, v3));
        directedAdjacencyList.put(v2, Arrays.asList(v4));
        directedAdjacencyList.put(v3, Arrays.asList(v4));

        List<Map.Entry<Vertex, List<Vertex>>> sortedEntires = new LinkedList<>(directedAdjacencyList.entrySet());
        Collections.sort(sortedEntires, (entry1, entry2) -> {
            // character with greater frequency is printed first
            return entry1.getKey().getValue().compareTo(entry2.getKey().getValue());
        });

        for (Map.Entry<Vertex, List<Vertex>> entry: sortedEntires) {
            if (entry.getKey().getState().equals(VertexState.UNVISITED)) {
                depthFirstSearch(entry.getKey(), directedAdjacencyList, orderFirstVisited, orderFirstFinished, null, isCycle, true);
            }
        }

        /*for (Map.Entry<Vertex, List<Vertex>> entry: undirectedAdjacencyList.entrySet()) {
            if (entry.getKey().getState().equals(VertexState.UNVISITED)) {
                depthFirstSearch(entry.getKey(), undirectedAdjacencyList, orderFirstVisited, orderFirstFinished, parentMap, isCycle, false);
                components++;
            }
        }*/

        System.out.print("1. Order First Visited: ");
        printListContents(orderFirstVisited);
        System.out.print("2. Order First Finished: (Reverse Order is Topological Sort) ");
        printListContents(orderFirstFinished);
        System.out.println("3. No. of Components:" + components);
        System.out.println("5. Cycle Present:" + (isCycle.size() == 1));

    }

    private static void printListContents(List<Vertex> vertices) {
        for (Vertex v : vertices) {
            System.out.print(v.getValue() + "\t");
        }
        System.out.println();
    }

    public static void depthFirstSearch(Vertex current,
                                        Map<Vertex, List<Vertex>> adjacencyList,
                                        List<Vertex> orderFirstVisited,
                                        List<Vertex> orderFirstFinished,
                                        Map<Vertex, Vertex> parentMap,
                                        Set<Boolean> isCycle,
                                        boolean isDirected) {
        // color it grey
        current.setState(VertexState.VISITED);
        orderFirstVisited.add(current);
        List<Vertex> descendants = adjacencyList.get(current);

        if (descendants != null) {
            for (Vertex descendant : descendants) {
                // check if the color is white
                if (descendant.getState().equals(VertexState.UNVISITED)) {
                    if (!isDirected) {
                        parentMap.put(descendant, current);
                    }
                    depthFirstSearch(descendant, adjacencyList, orderFirstVisited, orderFirstFinished, parentMap, isCycle, isDirected);
                } else if (descendant.getState().equals(VertexState.VISITED)) {
                    // this is for the ancestor case
                    if (isDirected) {
                        //IMPORTANT: the edge has to be strictly gray (only a back edge) for cycle to be present
                        isCycle.add(true);
                    } else {
                        // IMPORTANT: This is true only for undirected graph
                        if (parentMap.get(current) != descendant) {
                        isCycle.add(true);
                        }
                    }
                } else {
                    //this is for the descendant case/ black edge
                }
            }
        }

        // color it black
        current.setState(VertexState.EXHAUSTED);
        orderFirstFinished.add(current);
    }
}
