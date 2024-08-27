package org.snoflo.library;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.CsvFileManager;
import org.snoflo.csv.LibraryCsvFileManager;
import org.snoflo.model.Book;

public class LibraryService {

    private List<String[]> data;
    private List<Book> bookList;
    private CsvFileManager csvFileManager;

    private static LibraryService instance;

    public LibraryService () {
        try {
			initialize();
		} catch (IOException e) {
            System.out.println("객체 생성x");
			e.printStackTrace();
		}
    }

    public static synchronized LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    private void initialize() throws IOException {
        this.csvFileManager = new LibraryCsvFileManager();
        generateLibraryCsvFile();
        if (bookList == null) {
            this.data = csvFileManager.readCsvFile();
            this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
        }
    }

    private void generateLibraryCsvFile() throws IOException {
        csvFileManager.generateCsvFile();
    }

    public List<Book> findBookByAuthor(String author) {
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

}
