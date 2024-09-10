package org.snoflo;

import org.snoflo.repository.CsvFileReader;
import org.snoflo.repository.CsvFileReaderImpl;
import org.snoflo.repository.QuestionDataConverter;

public class App2 {
    public static void main(String[] args) {

        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        QuestionDataConverter questionDataConverter = new QuestionDataConverter(csvFileReader);
    }
}
