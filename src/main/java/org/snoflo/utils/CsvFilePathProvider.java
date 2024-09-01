package org.snoflo.utils;

public class CsvFilePathProvider {

    public static String getCsvFilePath(String csvFile) {
        String rootPath = System.getProperty("user.dir");
        String appPath = "src/main/resources/csv";

        return rootPath + "/" + appPath + "/" + csvFile;
    }
}
