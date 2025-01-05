package com.logistics;

import java.util.*;

public class CongestionPredictor {
    private Map<String, List<Integer>> historicalTrafficData;

    public CongestionPredictor() {
        this.historicalTrafficData = new HashMap<>();
    }

    public void addTrafficData(String road, int congestionLevel) {
        historicalTrafficData.putIfAbsent(road, new ArrayList<>());
        historicalTrafficData.get(road).add(congestionLevel);
    }

    public double predictCongestion(String road) {
        List<Integer> data = historicalTrafficData.getOrDefault(road, new ArrayList<>());
        return data.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void adjustEdgeWeights(Graph graph) {
        for (String road : historicalTrafficData.keySet()) {
            double predictedCongestion = predictCongestion(road);
            for (Edge edge : graph.getEdges(road)) {
                edge.weight += predictedCongestion;
            }
        }
    }
}