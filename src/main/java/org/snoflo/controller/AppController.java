package org.snoflo.controller;

import java.util.List;
import java.util.Scanner;

import org.snoflo.dto.LibraryDto;
import org.snoflo.model.Book;
import org.snoflo.proxy.LibraryServiceProxy;
import org.snoflo.service.LibraryService;
import org.snoflo.service.LibraryServiceImpl;
import org.snoflo.service.ViewService;

public class AppController {

    private ViewService viewService;

    private LibraryService libraryService;

    private LibraryDto libraryDto;
    private Scanner scanner;

    public AppController() {
        this.viewService = new ViewService();
        // this.libraryService = (LibraryService) LibraryServiceProxy
        // .newProxyInstance(new LibraryServiceImpl(new LibraryDto()));
        this.scanner = new Scanner(System.in);
    }

    public void executeMainMenu() {
        viewService.showPromptMainMenu();
        viewService.showSelectMenu();
        // int number = scanner.nextInt();
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1 -> executeGenerateCsvFile();
            case 2 -> executeFindByAuthor();
            default -> executeMainMenu();
        }

    }

    public void executeGenerateCsvFile() {
        viewService.showPromptGenerateCsvFile();
        viewService.showPromptWriteCsvFileName();
        String csvFile = scanner.nextLine();
        viewService.showPromptWriteCsvFileRow();
        int row = Integer.parseInt(scanner.nextLine());

        libraryDto = new LibraryDto(csvFile, row);
        libraryService = (LibraryService) LibraryServiceProxy.newProxyInstance(new LibraryServiceImpl(libraryDto));
        viewService.showResultGenerateCsvFile();
        executeMainMenu();
    }

    public void executeFindByAuthor() {
        viewService.showPromptFindByAuthor();
        String name = scanner.nextLine();
        List<Book> bookListByAuthor = libraryService.findBookByAuthor(name);
        viewService.showResultFindByAuthor(bookListByAuthor);
    }

}
