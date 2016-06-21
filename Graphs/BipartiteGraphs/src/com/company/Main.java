package com.company;



import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<Vertex, List<Vertex>> adjcencyList = new HashMap<>();
        Vertex a = new Vertex('A');
        Vertex b = new Vertex('B');
        Vertex c = new Vertex('C');
        Vertex d = new Vertex('D');
        Vertex e = new Vertex('E');
        Vertex f = new Vertex('F');
        Vertex g = new Vertex('G');
        Vertex h = new Vertex('H');


        adjcencyList.put(a, Arrays.asList(b, c));
        adjcencyList.put(b, Arrays.asList(e, a));
        adjcencyList.put(c, Arrays.asList(e, d, a));
        adjcencyList.put(e, Arrays.asList(f));
        adjcencyList.put(f, Arrays.asList(h));
        adjcencyList.put(g, Arrays.asList(h));

        // this loop is for disjoint components
        /*for (Map.Entry<Vertex, List<Vertex>> entry : adjcencyList.entrySet()) {
            if (entry.getKey().state == VertexState.UNIVISTED) {
                entry.getKey().state = getInitialVertexState(entry.getKey(), adjcencyList);
                if (!isGraphBipartiteDFS(adjcencyList, entry.getKey(), entry.getKey().state)){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);*/

        for (Map.Entry<Vertex, List<Vertex>> entry : adjcencyList.entrySet()) {
            if (entry.getKey().state == VertexState.UNIVISTED) {
                entry.getKey().state = getInitialVertexState(entry.getKey(), adjcencyList);
                if (!isGraphBipartite(adjcencyList, entry.getKey())){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    private static VertexState getInitialVertexState(Vertex a, Map<Vertex, List<Vertex>> adjcencyList) {
      for (Vertex adj : adjcencyList.get(a)) {
            if (adj.state != VertexState.UNIVISTED) {
                if (adj.state == VertexState.BLUE) {
                    return VertexState.RED;
                } else {
                    return VertexState.BLUE;
                }
            }
        }
        return VertexState.BLUE;
    }

    public static boolean isGraphBipartite( Map<Vertex, List<Vertex>> adjcencyList, Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            VertexState currentState = curr.state;
            VertexState childState;
            if (currentState == VertexState.BLUE) {
                childState = VertexState.RED;
            } else {
                childState = VertexState.BLUE;
            }


            List<Vertex> children = adjcencyList.get(curr);
            if (children != null) {
                for (Vertex adjElement : children) {
                    if (adjElement.state == currentState) {
                        return false;
                    } else {
                        // the if condition important for undirected graphs/ cycles
                        if (adjElement.state != childState) {
                            adjElement.state = childState;
                            queue.add(adjElement);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isGraphBipartiteDFS( Map<Vertex, List<Vertex>> adjcencyList,
                                               Vertex curr, VertexState state) {
        curr.state = state;
        VertexState childState;
        if (state == VertexState.BLUE) {
            childState = VertexState.RED;
        } else {
            childState = VertexState.BLUE;
        }

        List<Vertex> children = adjcencyList.get(curr);
        if (children != null) {
            for (Vertex adjElement : children) {
                if (
                        adjElement.state == state ||
                        (adjElement.state != childState && !isGraphBipartiteDFS(adjcencyList, adjElement, childState))
                    ) {
                    return false;
                }
            }
        }
        return true;
    }
}
