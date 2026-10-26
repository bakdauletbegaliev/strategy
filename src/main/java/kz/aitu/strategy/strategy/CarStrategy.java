package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;

public class CarStrategy implements RouteStrategy {
    @Override
    public RouteResult calculate(Route route) {
        double hours = route.getDistanceKm() / 38.0;
        int minutes = (int) Math.ceil(hours * 60 + 8);
        long costKzt = Math.round(route.getDistanceKm() * 85 + 250);
        return new RouteResult("Car", minutes, costKzt, "Includes 8 minutes of traffic and parking");
    }
}
