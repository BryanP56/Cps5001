package com.logistics;

import java.util.Map;

public class ILDS {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("A", "C", 15);

        DeliveryScheduler scheduler = new DeliveryScheduler();
        scheduler.addVehicle("V1", 100);
        scheduler.addVehicle("V2", 50);
        scheduler.addDelivery("B", 30, 2);
        scheduler.addDelivery("C", 20, 1);
        scheduler.scheduleDeliveries();

        Map<String, Double> shortestPaths = Dijkstra.findShortestPath(graph, "A");
        System.out.println("Shortest Paths from A: " + shortestPaths);

        CongestionPredictor predictor = new CongestionPredictor();
        predictor.addTrafficData("A", 3);
        predictor.addTrafficData("A", 5);
        predictor.adjustEdgeWeights(graph);
        System.out.println("Adjusted edge weights based on congestion predictions.");
    }
}