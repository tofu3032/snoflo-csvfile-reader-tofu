package org.snoflo.controller;

import java.util.List;
import java.util.Scanner;

import org.snoflo.model.Book;
import org.snoflo.service.LibraryService;
import org.snoflo.service.ViewService;

public class AppController {
    
    private ViewService viewService;

    private LibraryService libraryService;

    private Scanner scanner;

    public AppController () {
        this.viewService = new ViewService();
        this.libraryService = LibraryService.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void executeMainMenu () {
        viewService.showMainDisplay();
        viewService.showSelectDisplay();
        int number = scanner.nextInt();

        if (number == 1) {
            executeFindByAuthor();
        }
    }

    public void executeFindByAuthor() {
        viewService.showMenuFindByAuthor();
        scanner.nextLine();
        String name = scanner.nextLine();
        List<Book> bookListByAuthor = libraryService.findBookByAuthor(name);
        viewService.showResultFindByAuthor(bookListByAuthor);
    }


}
