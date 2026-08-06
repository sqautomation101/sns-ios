package util;

import com.opencsv.CSVReaderHeaderAware;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVDataReader {

    /**
     * Reads a CSV file with headers and returns all rows as a list of maps.
     * Each map represents a row with key = header, value = cell value.
     *
     * @param filePath path to CSV file
     * @return List of Map<String, String> where each map is a CSV row
     * @throws Exception if file not found or read error
     */

    public static List<Map<String, String>> readCsvWithHeader(String filePath) throws Exception {
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(filePath));
        List<Map<String, String>> allRows = new ArrayList<>();
        Map<String, String> row;

        while ((row = reader.readMap()) != null) {
            allRows.add(row);
        }

        reader.close();
        return allRows;
    }
}