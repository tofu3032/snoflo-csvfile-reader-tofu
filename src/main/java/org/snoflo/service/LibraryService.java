package org.snoflo.service;

import java.util.List;

import org.snoflo.model.Book;

public interface LibraryService {
    
    public List<Book> findBookByAuthor (String author);
}
