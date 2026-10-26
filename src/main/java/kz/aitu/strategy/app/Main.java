package kz.aitu.strategy.app;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import kz.aitu.strategy.context.Navigator;
import kz.aitu.strategy.model.Route;
import kz.aitu.strategy.model.RouteResult;
import kz.aitu.strategy.strategy.BicycleStrategy;
import kz.aitu.strategy.strategy.CarStrategy;
import kz.aitu.strategy.strategy.RouteStrategy;
import kz.aitu.strategy.strategy.WalkingStrategy;

public class Main {
    public static void main(String[] args) {
        Map<Integer, RouteStrategy> options = new LinkedHashMap<>();
        options.put(1, new WalkingStrategy());
        options.put(2, new BicycleStrategy());
        options.put(3, new CarStrategy());

        Route route = new Route("Student Dormitory", "Astana IT University", 7.5);
        Navigator navigator = new Navigator(options.get(1));

        System.out.println("CITY ROUTE PLANNER");
        System.out.println(route.getStart() + " -> " + route.getDestination());
        System.out.println("Distance: " + route.getDistanceKm() + " km");
        System.out.println();
        System.out.println("Automatic strategy switching:");

        for (RouteStrategy option : options.values()) {
            navigator.setStrategy(option);
            printResult(navigator.planRoute(route));
        }

        if (args.length > 0 && args[0].equals("--interactive")) {
            runMenu(navigator, route, options);
        }
    }

    private static void runMenu(Navigator navigator, Route route,
                                Map<Integer, RouteStrategy> options) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Choose transport: 1 - Walking, 2 - Bicycle, 3 - Car, 0 - Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextLine()) {
                return;
            }
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                System.out.println("Goodbye!");
                return;
            }

            try {
                int choice = Integer.parseInt(input);
                RouteStrategy selected = options.get(choice);
                if (selected == null) {
                    System.out.println("Choose 1, 2, 3 or 0.");
                } else {
                    navigator.setStrategy(selected);
                    printResult(navigator.planRoute(route));
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static void printResult(RouteResult result) {
        System.out.println(result.getTransport() + ": " + result.getMinutes()
                + " min, " + result.getCostKzt() + " KZT");
        System.out.println("  " + result.getNote());
    }
}
