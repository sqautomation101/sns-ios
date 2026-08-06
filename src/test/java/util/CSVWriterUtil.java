package util;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

/**
 * Appending CSV
 * */
public class CSVWriterUtil {

    public static void writeModuleTimings(
            java.util.Map<String, Long> startMap,
            java.util.Map<String, Long> endMap) {

        try {
            String folder = "initial";
            String csvPath = "target/reports/csv/" + folder + "/SNS_Module_Duration_Summary.csv";
            java.io.File csvFile = new java.io.File(csvPath);

            if (!csvFile.exists()) {
                csvFile.getParentFile().mkdirs();
                csvFile.createNewFile();
            }

            try (java.io.FileWriter writer = new java.io.FileWriter(csvFile, false)) {

                writer.append("Module,Start Time,End Time,Duration\n");

                for (String module : startMap.keySet()) {

                    long start = startMap.get(module);
                    long end = endMap.getOrDefault(module, start);

                    String startTime = TimeUtil.formatMillis(start);
                    String endTime = TimeUtil.formatMillis(end);
                    String duration = TimeUtil.formatDuration(start, end);

                    writer.append(String.format("%s,%s,%s,%s\n",
                            module,
                            startTime,
                            endTime,
                            duration));
                }
            }

            System.out.println("✅ Module Duration Summary CSV generated: " + csvPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeSuiteSummary(String suiteStart, String suiteEnd, String duration) {
        try {
            String folder = "initial";
            String csvPath = "target/reports/csv/" + folder + "/SNS_Suite_Duration_Summary.csv";
            File csvFile = new File(csvPath);

            // Make sure parent directories exist
            if (!csvFile.exists()) {
                csvFile.getParentFile().mkdirs();
                csvFile.createNewFile();
            }

            // Overwrite each run
            try (FileWriter writer = new FileWriter(csvFile, false)) {
                // Write header
                writer.append("Suite Start,Suite End,Total Duration\n");
                // Write suite values
                writer.append(String.format("%s,%s,%s\n", suiteStart, suiteEnd, duration));
            }

            System.out.println("✅ Suite Duration Summary CSV generated: " + csvPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCsvWithHeader(
            String filePath,
            List<Map<String, String>> rows) {

        try (FileWriter writer = new FileWriter(filePath, false)) {

            // header
            writer.append("CardNumber,CardStatus,Used,Notes,Code\n");

            // rows
            for (Map<String, String> row : rows) {

                writer.append(String.format("%s,%s,%s,%s,%s\n",
                        row.get("CardNumber"),
                        row.get("CardStatus"),
                        row.get("Used"),
                        row.get("Notes"),
                        row.get("Code")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCsvWithHeader_With_Name(
            String filePath,
            List<Map<String, String>> rows) {

        try (FileWriter writer = new FileWriter(filePath, false)) {

            // header
            writer.append("CardNumber,CardStatus,Used,Notes,Code,NameOnCard\n");

            // rows
            for (Map<String, String> row : rows) {

                writer.append(String.format("%s,%s,%s,%s,%s,%s\n",
                        row.get("CardNumber"),
                        row.get("CardStatus"),
                        row.get("Used"),
                        row.get("Notes"),
                        row.get("Code"),
                        row.get("NameOnCard")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}