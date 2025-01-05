package com.logistics;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String id;
    private int capacity;
    private int currentLoad;
    private List<Delivery> deliveries;

    public Vehicle(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentLoad = 0;
        this.deliveries = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getRemainingCapacity() {
        return capacity - currentLoad;
    }

    public void assignDelivery(Delivery delivery) {
        if (currentLoad + delivery.weight <= capacity) {
            deliveries.add(delivery);
            currentLoad += delivery.weight;
        } else {
            throw new IllegalStateException("Delivery exceeds vehicle capacity!");
        }
    }
}