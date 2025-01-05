package com.logistics;

import java.util.*;

public class Dijkstra {
    public static Map<String, Double> findShortestPath(Graph graph, String start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(node -> node.distance));
        Map<String, Double> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.getAdjacencyList().keySet()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(start, 0.0);
        pq.add(new Node(start, 0.0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            for (Edge edge : graph.getEdges(current.name)) {
                if (!visited.contains(edge.to)) {
                    double newDist = distances.get(current.name) + edge.weight;
                    if (newDist < distances.get(edge.to)) {
                        distances.put(edge.to, newDist);
                        pq.add(new Node(edge.to, newDist));
                    }
                }
            }
        }

        return distances;
    }
}

class Node {
    String name;
    double distance;

    public Node(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }
}