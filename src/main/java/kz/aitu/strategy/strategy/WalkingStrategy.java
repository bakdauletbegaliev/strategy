package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;

public class WalkingStrategy implements RouteStrategy {
    @Override
    public RouteResult calculate(Route route) {
        double hours = route.getDistanceKm() / 5.0;
        int minutes = (int) Math.ceil(hours * 60);
        return new RouteResult("Walking", minutes, 0, "Walking speed: 5 km/h");
    }
}
