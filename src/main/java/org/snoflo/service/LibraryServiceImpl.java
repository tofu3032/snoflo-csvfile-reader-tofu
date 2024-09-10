package org.snoflo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.dto.LibraryDto;
import org.snoflo.model.Book;
import org.snoflo.repository.LibraryCsvFileManager;
import org.snoflo.repository.LibraryDataConverter;

public class LibraryServiceImpl implements LibraryService {

    private LibraryDataConverter libraryDataConverter;

    private LibraryDto libraryDto;

    public LibraryServiceImpl(LibraryDto libraryDto) {
        this.libraryDto = libraryDto;
        this.libraryDataConverter = new LibraryDataConverter(new LibraryCsvFileManager(libraryDto.getNameOfCsvFile(), libraryDto.getRowOfCsvFile()));
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> bookList = libraryDataConverter.getBookList();
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

}
