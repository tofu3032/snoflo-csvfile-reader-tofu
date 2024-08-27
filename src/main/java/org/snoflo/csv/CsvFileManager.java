package org.snoflo.csv;

import java.io.IOException;
import java.util.List;

public interface CsvFileManager {

    void generateCsvFile() throws IOException;

    List<String[]> readCsvFile() throws IOException;

    void writeCsvFile(List<String[]> data) throws IOException;

}
