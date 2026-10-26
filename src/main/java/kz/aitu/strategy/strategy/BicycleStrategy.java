package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;

public class BicycleStrategy implements RouteStrategy {
    @Override
    public RouteResult calculate(Route route) {
        double hours = route.getDistanceKm() / 14.0;
        int minutes = (int) Math.ceil(hours * 60 + 2);
        return new RouteResult("Bicycle", minutes, 0, "Includes 2 minutes to park the bicycle");
    }
}
