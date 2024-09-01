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
        // viewService.showSelectDisplayIfFileNotExist();
        
        
        /* 

         * 첫 시작시 파일 생성 메뉴 강제
         * 
         * switch () {
         * 
         * select 1 -> 파일 생성
         * select 2 -> 
         * }
         */
    }

    public void selectMenu() {
        viewService.showMainDisplay();
        int menuButton = scanner.nextInt();

        if (menuButton == 1) {
        } else if (menuButton == 2) {

        }
    }

    public void executeFindByAuthor() {
        viewService.showMenuFindByAuthor();
        String name = scanner.nextLine();
        List<Book> bookListByAuthor = libraryService.findBookByAuthor(name);
        viewService.showResultFindByAuthor(bookListByAuthor);
    }


}
