package kz.aitu.strategy.model;

public class RouteResult {
    private final String transport;
    private final int minutes;
    private final long costKzt;
    private final String note;

    public RouteResult(String transport, int minutes, long costKzt, String note) {
        this.transport = transport;
        this.minutes = minutes;
        this.costKzt = costKzt;
        this.note = note;
    }

    public String getTransport() {
        return transport;
    }

    public int getMinutes() {
        return minutes;
    }

    public long getCostKzt() {
        return costKzt;
    }

    public String getNote() {
        return note;
    }
}
