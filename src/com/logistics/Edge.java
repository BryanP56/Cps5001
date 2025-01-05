package com.logistics;

public class Edge {
    String to;
    double weight;

    public Edge(String to, double weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to='" + to + '\'' +
                ", weight=" + weight +
                '}';
    }
}