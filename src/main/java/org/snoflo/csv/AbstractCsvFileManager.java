package org.snoflo.csv;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.snoflo.utils.CsvFilePathProvider;

public abstract class AbstractCsvFileManager {

    protected String csvFile;

    protected int row;

    protected Random random;

    public AbstractCsvFileManager(String csvFile, int row) {
        this.csvFile = CsvFilePathProvider.getCsvFilePath(csvFile); 
        this.row = row;
        this.random = new Random();
    }

    abstract void generateCsvFile() throws IOException;

    abstract List<String[]> readCsvFile() throws IOException;

    abstract void writeCsvFile(List<String[]> data) throws IOException;
}