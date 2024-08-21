package csv;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    private CsvUtils() {}

    public static List<String[]> readCsv(String filename) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    public static void writeCsv(String filename, List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String[] row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }
    }
}