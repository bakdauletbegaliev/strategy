package kz.aitu.strategy.strategy;

import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;

public interface RouteStrategy {
    RouteResult calculate(Route route);
}
