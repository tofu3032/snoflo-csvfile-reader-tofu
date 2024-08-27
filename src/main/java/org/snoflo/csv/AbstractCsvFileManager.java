package org.snoflo.csv;

import java.io.IOException;
import java.util.List;

public abstract class AbstractCsvFileManager {

    protected String csvFile;

    protected int row;

    public AbstractCsvFileManager () {
        this.csvFile = "library.csv";
        this.row = 100;
    }

    public AbstractCsvFileManager (String csvFile, int row) {
        this.csvFile = csvFile;
        this.row = row;
    }

    abstract void generateCsvFile() throws IOException;

    abstract List<String[]> readCsvFile() throws IOException;

    abstract void writeCsvFile(List<String[]> data) throws IOException;

}
