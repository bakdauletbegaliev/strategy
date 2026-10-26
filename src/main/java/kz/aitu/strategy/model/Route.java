package kz.aitu.strategy.model;

public class Route {
    private final String start;
    private final String destination;
    private final double distanceKm;

    public Route(String start, String destination, double distanceKm) {
        if (start == null || start.isBlank()) {
            throw new IllegalArgumentException("Start location cannot be empty");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination cannot be empty");
        }
        if (!Double.isFinite(distanceKm) || distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be a positive number");
        }
        this.start = start;
        this.destination = destination;
        this.distanceKm = distanceKm;
    }

    public String getStart() {
        return start;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistanceKm() {
        return distanceKm;
    }
}
