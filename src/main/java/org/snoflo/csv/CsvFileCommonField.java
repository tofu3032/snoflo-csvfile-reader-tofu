package org.snoflo.csv;

import java.util.Random;

public abstract class CsvFileCommonField {

    protected String csvFile;

    protected int row;

    protected Random random;

    public CsvFileCommonField(String csvFile, int row) {
        this.csvFile = csvFile;
        this.row = row;
        this.random = new Random();
    }
}
