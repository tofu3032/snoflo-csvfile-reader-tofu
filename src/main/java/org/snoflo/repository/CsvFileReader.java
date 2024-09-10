package org.snoflo.repository;

import java.util.List;

public interface CsvFileReader {

    List<String[]> readCsvFile(String csvFile);
}
