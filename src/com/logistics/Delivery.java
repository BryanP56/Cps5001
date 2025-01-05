package com.logistics;

public class Delivery {
    String destination;
    int weight;
    int deadline;

    public Delivery(String destination, int weight, int deadline) {
        this.destination = destination;
        this.weight = weight;
        this.deadline = deadline;
    }

    public int getDeadline() {
        return deadline;
    }
}