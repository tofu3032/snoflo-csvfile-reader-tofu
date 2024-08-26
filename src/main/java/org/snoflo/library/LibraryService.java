package org.snoflo.library;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.CsvUtils;
import org.snoflo.model.Book;

public class LibraryService {

    private List<String[]> data;
    private List<Book> bookList;
    


    public LibraryService() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {
        Path rootDir = Paths.get("").toAbsolutePath();
        Path csvFile = rootDir.resolve("library.csv");

        this.data = CsvUtils.readCsv(CsvUtils.getCSV_FILE());
        this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

}
