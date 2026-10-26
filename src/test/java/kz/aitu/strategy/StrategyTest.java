package kz.aitu.strategy;

import kz.aitu.strategy.context.Navigator;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;
import kz.aitu.strategy.strategy.BicycleStrategy;
import kz.aitu.strategy.strategy.CarStrategy;
import kz.aitu.strategy.strategy.RouteStrategy;
import kz.aitu.strategy.strategy.WalkingStrategy;

public class StrategyTest {
    public static void main(String[] args) {
        Route route = new Route("A", "B", 7.5);
        Navigator navigator = new Navigator(new WalkingStrategy());
        RouteResult walking = navigator.planRoute(route);
        check(walking.getMinutes() == 90, "Walking time");
        check(walking.getCostKzt() == 0, "Walking cost");

        navigator.setStrategy(new BicycleStrategy());
        RouteResult bicycle = navigator.planRoute(route);
        check(bicycle.getMinutes() == 35, "Bicycle time");
        check(bicycle.getCostKzt() == 0, "Bicycle cost");

        navigator.setStrategy(new CarStrategy());
        RouteResult car = navigator.planRoute(route);
        check(car.getMinutes() == 20, "Car time");
        check(car.getCostKzt() == 888, "Car cost");
        check(car.getMinutes() < bicycle.getMinutes(), "Runtime strategy switch");

        RouteStrategy scooter = new RouteStrategy() {
            @Override
            public RouteResult calculate(Route route) {
                return new RouteResult("Scooter", 25, 300, "Test strategy");
            }
        };
        navigator.setStrategy(scooter);
        check(navigator.planRoute(route).getTransport().equals("Scooter"),
                "New strategy without editing Navigator");

        expectError(() -> new Route("A", "B", 0), "Zero distance");
        expectError(() -> new Route("", "B", 4), "Empty location");
        expectError(() -> navigator.setStrategy(null), "Null strategy");
        System.out.println("All 9 checks passed.");
    }

    private static void check(boolean condition, String name) {
        if (!condition) {
            throw new AssertionError("Failed: " + name);
        }
    }

    private static void expectError(Runnable action, String name) {
        try {
            action.run();
        } catch (IllegalArgumentException | NullPointerException e) {
            return;
        }
        throw new AssertionError("Failed: " + name);
    }
}
