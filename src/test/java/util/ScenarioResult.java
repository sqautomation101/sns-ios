package util;

/**
 * This is for CSV column naming/format
 */
public class ScenarioResult {

    public String module;
    public String scenario;
    public String status;
    public String errorMessage;

    public long startMillis;
    public long endMillis;

    public ScenarioResult(String module,
                          String scenario,
                          String status,
                          String errorMessage) {
        this.module = module;
        this.scenario = scenario;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getDuration() {
        long duration = endMillis - startMillis;
        long seconds = duration / 1000;

        return String.format("%02d:%02d:%02d",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60);
    }
}