package org.snoflo.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.model.Book;
import org.snoflo.utils.CsvFilePathProvider;

public class LibraryDataConverter {

    private List<String[]> data;
    private List<Book> bookList;
    private AbstractCsvFileManager csvFileManager;

    public LibraryDataConverter(AbstractCsvFileManager csvFileManager) {
        this.csvFileManager = csvFileManager;
        try {
            generateData();
            convertData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateData() throws IOException {
        Path path = Paths.get(CsvFilePathProvider.getCsvFilePath("library.csv"));
        if (Files.notExists(path)) {
            csvFileManager.generateCsvFile();
        } else {
            csvFileManager.generateCsvFile();
        }

    }

    private void convertData() throws IOException {
        if (bookList == null) {
            this.data = csvFileManager.readCsvFile();
            this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
        }
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
