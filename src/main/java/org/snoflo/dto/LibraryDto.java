package org.snoflo.dto;

public class LibraryDto {

    private String nameOfCsvFile;

    private int rowOfCsvFile;

    public LibraryDto(String nameOfCsvFile, int rowOfCsvFile) {
        this.nameOfCsvFile = nameOfCsvFile;
        this.rowOfCsvFile = rowOfCsvFile;
    }

    public String getNameOfCsvFile() {
        return nameOfCsvFile;
    }

    public void setNameOfCsvFile(String nameOfCsvFile) {
        this.nameOfCsvFile = nameOfCsvFile;
    }

    public int getRowOfCsvFile() {
        return rowOfCsvFile;
    }

    public void setRowOfCsvFile(int rowOfCsvFile) {
        this.rowOfCsvFile = rowOfCsvFile;
    }

}
