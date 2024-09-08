package org.snoflo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.csv.LibraryCsvFileManager;
import org.snoflo.csv.LibraryDataConverter;
import org.snoflo.dto.LibraryDto;
import org.snoflo.model.Book;

public class LibraryServiceImpl implements LibraryService {

    private LibraryDataConverter libraryDataConverter;
    private static LibraryService instance;

    private LibraryDto libraryDto;

    public LibraryServiceImpl(LibraryDto libraryDto) {
        // this.libraryDto = new LibraryDto("library.csv", 100);
        this.libraryDto = libraryDto;
        this.libraryDataConverter = new LibraryDataConverter(new LibraryCsvFileManager(libraryDto.getNameOfCsvFile(), libraryDto.getRowOfCsvFile()));
    }

  /*   public static synchronized LibraryService getInstance() {
        if (instance == null) {
            // instance = new LibraryServiceImpl();
            instance = (LibraryService) LibraryServiceProxy.newProxyInstance(new LibraryServiceImpl());
        } 
        return instance;
    } */


    public List<Book> findBookByAuthor(String author) {
        List<Book> bookList = libraryDataConverter.getBookList();
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

}
