package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex u = new Vertex("u");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");

        Edge infinity = new Edge(null, null, Integer.MAX_VALUE);
        Edge oneLessThanEnfinity =  new Edge(null, null, Integer.MAX_VALUE - 1);

        Edge ab = new Edge(a, b, 2);
        Edge au = new Edge(a, u, 1);
        Edge uv = new Edge(u, v, 1);
        Edge av = new Edge(a, v, 1);

        Edge bc = new Edge(b, c, 5);
        Edge bv = new Edge(b, v, 6);
        Edge vw = new Edge(v, w, 2);
        Edge bw = new Edge(b, w, 3);

        Edge cd = new Edge(c, d, 5);
        Edge cw = new Edge(c, w, 6);
        Edge wx = new Edge(w, x, 4);
        Edge cx = new Edge(c, x, 4);

        Edge dx = new Edge(d, x, 3);

        Map<Vertex, List<Edge>> adjacencyList = new HashMap<>();
        adjacencyList.put(a, Arrays.asList(au, ab, av));
        adjacencyList.put(b, Arrays.asList(ab, bv, bw, bc));
        adjacencyList.put(c, Arrays.asList(bc, cd, cw, cx));
        adjacencyList.put(d, Arrays.asList(cd, dx));
        adjacencyList.put(u, Arrays.asList(au, uv));
        adjacencyList.put(v, Arrays.asList(av, uv, bv, vw));
        adjacencyList.put(w, Arrays.asList(vw, bw, cw, wx));
        adjacencyList.put(x, Arrays.asList(wx, cx, dx));

        Map<Vertex, Edge> bestDistanceInR = new HashMap<>();

        PriorityQueue<Map.Entry<Vertex, Edge>> queue = new PriorityQueue(100, new Comparator<Map.Entry<Vertex, Edge>>() {
            @Override
            public int compare(Map.Entry<Vertex, Edge> entry1, Map.Entry<Vertex, Edge> entry2) {
                return entry1.getValue().getWeight() - entry2.getValue().getWeight();
            }
        });

        bestDistanceInR.put(a, infinity);
        bestDistanceInR.put(b, infinity);
        bestDistanceInR.put(c, infinity);
        bestDistanceInR.put(d, infinity);
        bestDistanceInR.put(u, infinity);
        bestDistanceInR.put(v, infinity);
        bestDistanceInR.put(w, oneLessThanEnfinity);
        bestDistanceInR.put(x, infinity);

        queue.addAll(bestDistanceInR.entrySet());
        int spanningTreeValue = 0;

        while (!queue.isEmpty()) {
            // get the vertex which is closest (minimum weight) to R/ has best distance from R
            Map.Entry<Vertex, Edge> mapEntry = queue.poll();
            Vertex currentVertex = mapEntry.getKey();

            // set inqueue of that vertex to be true
            currentVertex.setPresentInR(true);

            // get the current pie(v) distance
            Edge nearestEdge = bestDistanceInR.get(currentVertex);

            if (nearestEdge.equals(infinity) || nearestEdge.equals(oneLessThanEnfinity)) {
                System.out.println(currentVertex.getValue());
            } else {
                // add the value to spanning count
                spanningTreeValue += nearestEdge.getWeight();
                System.out.println(nearestEdge.getV1().getValue() + "-------" + nearestEdge.getV2().getValue() + ":" +  nearestEdge.getWeight());
            }

            for (Edge e : adjacencyList.get(currentVertex)) {
                Vertex otherVertex;
                // get the other end of the edge vertex
                if (!e.getV1().equals(currentVertex)) {
                    otherVertex = e.getV1();
                } else {
                    otherVertex = e.getV2();
                }

                Edge currEdge = bestDistanceInR.get(otherVertex);

                // if the edge value is less than its current best distance from R
                // because of the addition of the current vertex then update its best distance
                if (!otherVertex.isPresentInR() && currEdge.getWeight() > e.getWeight()) {
                    bestDistanceInR.put(otherVertex, e);

                    // Decrease key not supported by PriorityQueue, so remove the map entry and add it back
                    Map.Entry<Vertex, Edge> entry = getMapEntry(bestDistanceInR, otherVertex);
                    queue.remove(entry);
                    queue.offer(entry);
                }
            }
        }

        System.out.println("Spanning Tree value:" + spanningTreeValue);


    }

    private static Map.Entry<Vertex,Edge> getMapEntry(Map<Vertex, Edge> bestDistanceInR, Vertex otherVertex) {
        for (Map.Entry<Vertex, Edge> entry: bestDistanceInR.entrySet()) {
            if (entry.getKey().equals(otherVertex)) {
                return entry;
            }
        }
        return null;
    }


}
