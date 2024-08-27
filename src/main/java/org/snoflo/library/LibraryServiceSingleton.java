package org.snoflo.library;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.LibraryCsvFileManager;
import org.snoflo.model.Book;

public class LibraryServiceSingleton {

    private List<String[]> data;
    private List<Book> bookList;

    private static LibraryServiceSingleton instance;

    public LibraryServiceSingleton() throws IOException {
        this.data = LibraryCsvFileManager.readCsv();
        this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
    }

    public static synchronized LibraryServiceSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new LibraryServiceSingleton();
        }
        return instance;
    }

    public List<Book> findBookByAuthor(String author) {
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

}
