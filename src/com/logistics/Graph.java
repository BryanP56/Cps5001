package com.logistics;

import java.util.*;

public class Graph {
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, double weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    public void removeNode(String node) {
        adjacencyList.remove(node);
        for (List<Edge> edges : adjacencyList.values()) {
            edges.removeIf(edge -> edge.to.equals(node));
        }
    }

    public void removeEdge(String from, String to) {
        List<Edge> edges = adjacencyList.get(from);
        if (edges != null) {
            edges.removeIf(edge -> edge.to.equals(to));
        }
    }

    public void updateEdgeWeight(String from, String to, double newWeight) {
        for (Edge edge : adjacencyList.getOrDefault(from, new ArrayList<>())) {
            if (edge.to.equals(to)) {
                edge.weight = newWeight;
                break;
            }
        }
    }

    public List<Edge> getEdges(String node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}