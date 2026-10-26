package kz.aitu.strategy.context;

import java.util.Objects;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;
import kz.aitu.strategy.strategy.RouteStrategy;

public class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public RouteResult planRoute(Route route) {
        Objects.requireNonNull(route, "Route cannot be null");
        return strategy.calculate(route);
    }
}
