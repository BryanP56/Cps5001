package com.logistics;

import java.util.*;

public class DeliveryScheduler {
    private PriorityQueue<Delivery> deliveryQueue;
    private Map<String, Vehicle> vehicles;

    public DeliveryScheduler() {
        this.deliveryQueue = new PriorityQueue<>(Comparator.comparingInt(Delivery::getDeadline));
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(String id, int capacity) {
        vehicles.put(id, new Vehicle(id, capacity));
    }

    public void addDelivery(String destination, int weight, int deadline) {
        deliveryQueue.add(new Delivery(destination, weight, deadline));
    }

    public void scheduleDeliveries() {
        while (!deliveryQueue.isEmpty()) {
            Delivery delivery = deliveryQueue.poll();

            Vehicle assignedVehicle = null;
            for (Vehicle vehicle : vehicles.values()) {
                if (vehicle.getRemainingCapacity() >= delivery.weight) {
                    assignedVehicle = vehicle;
                    break;
                }
            }

            if (assignedVehicle != null) {
                assignedVehicle.assignDelivery(delivery);
                System.out.println("Assigned delivery to vehicle: " + assignedVehicle.getId());
            } else {
                System.out.println("No available vehicle for delivery: " + delivery.destination);
            }
        }
    }
}