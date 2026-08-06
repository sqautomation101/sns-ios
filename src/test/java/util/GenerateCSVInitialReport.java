package util;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.*;

/**
 * CSV Generation - Initial
 * */
public class GenerateCSVInitialReport {

    public static void main(String[] args) throws Exception {


        String[] jsonFiles = {
                "target/cucumber-json/initial/account.json",
                "target/cucumber-json/initial/bottomNav.json",
                "target/cucumber-json/initial/cardBlocking.json",
                "target/cucumber-json/initial/cardLinking.json",
                "target/cucumber-json/initial/guestuser.json",
                "target/cucumber-json/initial/homepage.json",
                "target/cucumber-json/initial/inbox.json",
                "target/cucumber-json/initial/login.json",
                "target/cucumber-json/initial/managecards.json",
                "target/cucumber-json/initial/MOMCardAttribute.json",
                "target/cucumber-json/initial/offlinevirtualcard.json",
                "target/cucumber-json/initial/ptshistory.json",
                "target/cucumber-json/initial/qrandscan.json",
                "target/cucumber-json/initial/ssomenu.json",
                "target/cucumber-json/initial/rtp.json"
        };

        Map<String, ScenarioResult> scenarioMap = new HashMap<>();

        for (String path : jsonFiles) {
            File file = new File(path);
            if (!file.exists() || file.length() == 0) continue;

            String content = new String(Files.readAllBytes(file.toPath()));
            JSONArray features = new JSONArray(content);

            for (int i = 0; i < features.length(); i++) {
                JSONObject feature = features.getJSONObject(i);
                String module = feature.getString("name");

                JSONArray scenarios = feature.getJSONArray("elements");
                for (int j = 0; j < scenarios.length(); j++) {
                    JSONObject scenario = scenarios.getJSONObject(j);
                    String type = scenario.getString("type");

                    if (!type.equals("scenario") && !type.equals("scenario_outline")) continue;

                    String scenarioName = scenario.getString("name");
                    JSONArray steps = scenario.getJSONArray("steps");

                    String status = "PASSED";
                    String errorMessage = "";

                    for (int k = 0; k < steps.length(); k++) {
                        String stepStatus = steps.getJSONObject(k)
                                .getJSONObject("result")
                                .getString("status");

                        switch (stepStatus.toLowerCase()) {
                            case "failed":
                                status = "FAILED";

                                JSONObject result = steps.getJSONObject(k).getJSONObject("result");

                                if (result.has("error_message")) {
                                    errorMessage = result.getString("error_message").split("\n")[0];
                                }

                                break;

                            case "skipped":
                                status = "SKIPPED";
                                break;
                        }

                        if (!status.equals("PASSED")) {
                            break;
                        }
                    }

                    scenarioMap.put(module + "_" + scenarioName, new ScenarioResult(module, scenarioName, status, errorMessage));
                }
            }
        }

        File csvDir = new File("target/reports/csv/initial/07-28-2026");
        if (!csvDir.exists()) csvDir.mkdirs();

        generateScenarioCSV(scenarioMap);
        generateModuleCSV(scenarioMap);

        System.out.println("\n🟢 CSV Reports Generated Successfully");
    }

    private static void generateScenarioCSV
            (Map<String, ScenarioResult> map) throws Exception {
        System.out.println("Generating Scenario Summary...");

        FileWriter writer = new FileWriter("target/reports/csv/initial/SNS_Release_24-Initial_Scenario_Summary.csv");
        writer.append("TC#,Module,Scenario,Status,Error Message\n");

        List<ScenarioResult> sortedScenarios = new ArrayList<>(map.values());
        sortedScenarios.sort(Comparator.comparing((ScenarioResult r) -> r.module).thenComparing(r -> r.scenario));

        int tcNumber = 1;
        for (ScenarioResult r : sortedScenarios) {
            writer.append(String.format(
                    "TC%02d,%s,%s,%s,\"%s\"\n",
                    tcNumber++,
                    r.module,
                    r.scenario,
                    r.status,
                    r.errorMessage
            ));
        }

        writer.close();
        System.out.println("SNS_Release_24-Initial_Scenario_Summary.csv generated successfully in target/reports/csv/initial/");
    }

    private static void generateModuleCSV(Map<String, ScenarioResult> map) throws Exception {
        System.out.println("Generating Module Summary...");
        Map<String, int[]> summary = new HashMap<>();

        for (ScenarioResult r : map.values()) {
            summary.putIfAbsent(r.module, new int[4]);
            int[] counts = summary.get(r.module);
            counts[0]++;
            switch (r.status.toLowerCase()) {
                case "passed": counts[1]++; break;
                case "failed": counts[2]++; break;
                case "skipped": counts[3]++; break;
            }
        }

        FileWriter writer = new FileWriter("target/reports/csv/initial/SNS_Release_24-Initial_Module_Summary.csv");
        writer.append("Module,Total TC,Passed,Failed,Skipped\n");

        List<String> sortedModules = new ArrayList<>(summary.keySet());
        Collections.sort(sortedModules);

        for (String module : sortedModules) {
            int[] c = summary.get(module);
            writer.append(String.format("%s,%d,%d,%d,%d\n", module, c[0], c[1], c[2], c[3]));
        }

        writer.close();
        System.out.println("SNS_Release_24-Initial_Module_Summary.csv generated successfully in target/reports/csv/initial/");
    }
}