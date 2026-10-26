# City Route Planner — Strategy Pattern

**Student:** Begaliev Bakdaulet  
**Group:** SE-2526  
**Course:** Software Design Patterns, Assignment #5  
**University:** Astana IT University  
**Academic year:** 2026–2027  
**GitHub:** https://github.com/bakdauletbegaliev/strategy

A small Java 17 application that compares travel time and estimated cost for walking, bicycle, and car. The transport algorithm can be changed while the program is running. No external APIs or libraries are needed to run it.

## Design pattern

- **Strategy interface:** `RouteStrategy`
- **Concrete strategies:** `WalkingStrategy`, `BicycleStrategy`, `CarStrategy`
- **Context:** `Navigator` with `setStrategy()` and `planRoute()`
- **Client:** `Main`
- **Data classes:** `Route`, `RouteResult`

`Navigator` never checks which type of strategy it received. It simply calls `strategy.calculate(route)`.

## How to open in IntelliJ IDEA

1. Extract the ZIP archive and open the project folder with **File → Open**.
2. Select **JDK 17** (newer JDKs also work). If IntelliJ asks, import it as a **Maven** project.
3. Open `src/main/java/kz/aitu/strategy/app/Main.java`.
4. Click the green **Run** arrow beside `main`.
5. For an interactive live demo, add `--interactive` to **Run → Edit Configurations → Program arguments**, then run again.

## How to build and run in a terminal

```bash
mvn clean package
java -cp target/classes kz.aitu.strategy.app.Main
java -cp target/classes kz.aitu.strategy.app.Main --interactive
```

`mvn` needs Maven installed or the Maven command provided by IntelliJ. The application itself only needs Java 17 and does not depend on any downloaded runtime library.

### Run tests

In IntelliJ, run `src/test/java/kz/aitu/strategy/StrategyTest.java` using its green Run arrow. This is a simple self-contained test runner (no JUnit dependency).

On Windows PowerShell, from the project folder:

```powershell
.\scripts\run-tests.ps1
```

On Linux / macOS:

```bash
bash scripts/run-tests.sh
```

The test covers all three calculation methods, strategy switching, a new injected strategy, and invalid inputs.

## Demo output

```text
CITY ROUTE PLANNER
Student Dormitory -> Astana IT University
Distance: 7.5 km

Automatic strategy switching:
Walking: 90 min, 0 KZT
  Walking speed: 5 km/h
Bicycle: 35 min, 0 KZT
  Includes 2 minutes to park the bicycle
Car: 20 min, 888 KZT
  Includes 8 minutes of traffic and parking
```

These are simplified, educational estimates. The sample distance is entered manually; the app does not retrieve actual maps, traffic, or public transport prices.

## How to add a new strategy

1. Create `BusStrategy.java` in the `strategy` package.
2. Write `class BusStrategy implements RouteStrategy` and implement `calculate(Route route)`.
3. Return a `RouteResult` containing your estimated minutes and KZT price.
4. In `Main`, add `options.put(4, new BusStrategy())` and show option `4` in the menu.
5. **Do not edit `Navigator`.** It already works with any `RouteStrategy` implementation.

## UML and report

- [UML class diagram (PNG)](docs/uml/strategy-class-diagram.png)
- [UML class diagram (SVG)](docs/uml/strategy-class-diagram.svg)
- [Editable PlantUML source](docs/uml/strategy-class-diagram.puml)
- [Assignment report — REPORT.md, with visible UML](REPORT.md)
- [PDF report with embedded UML](REPORT_WITH_UML.pdf)
- [Defense notes in Russian](DEFENSE_GUIDE_RU.md)

**UML arrow meanings:** hollow diamond = strategy reference (aggregation); dashed line with hollow triangle = interface implementation; dashed arrow = dependency (uses).

## Project structure

```text
src/
  main/java/kz/aitu/strategy/
    app/Main.java
    context/Navigator.java
    model/Route.java, RouteResult.java
    strategy/RouteStrategy.java, WalkingStrategy.java,
             BicycleStrategy.java, CarStrategy.java
  test/java/kz/aitu/strategy/StrategyTest.java
docs/uml/
  strategy-class-diagram.png
  strategy-class-diagram.svg
  strategy-class-diagram.puml
REPORT.md
DEFENSE_GUIDE_RU.md
pom.xml
```

## Submission

Push this project to https://github.com/bakdauletbegaliev/strategy and upload **REPORT.md** (and its image file, if Moodle needs it), or use **REPORT_WITH_UML.pdf** as an additional readable copy before the deadline. Read and adapt the material in your own words: the course requires independent work and an individual defense.
