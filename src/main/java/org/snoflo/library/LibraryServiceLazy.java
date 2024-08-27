package org.snoflo.library;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.LibraryCsvFileManager;
import org.snoflo.model.Book;

public class LibraryServiceLazy {

    private List<String[]> data;
    private List<Book> bookList;

    public LibraryServiceLazy() throws IOException {
    }

    public List<Book> findBookByAuthor(String author) throws IOException {
        if (bookList == null) {
            this.data = LibraryCsvFileManager.readCsvFile();
            this.bookList = data.stream().skip(1).map(row -> createBookFromRow(row)).collect(Collectors.toList());
        }

        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    private Book createBookFromRow(String[] row) {
        return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
    }

}
