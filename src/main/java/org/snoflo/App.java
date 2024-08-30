package org.snoflo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.snoflo.model.Book;
import org.snoflo.service.LibraryService;

public class App {

    public static void main(String[] args) throws IOException {

        
        System.out.println("---------------------------------");
        System.out.println("도서관리 프로그램 시작");
        System.out.println("---------------------------------");

        LibraryService libraryService = new LibraryService();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("-----------------------------");
            System.out.println("---- Author로 검색하기 -----");
            String name = scanner.nextLine();

            long beforeTime = System.currentTimeMillis();
            List<Book> bookListByAuthor = libraryService.findBookByAuthor(name);
            long afterTime = System.currentTimeMillis();
            double secDiffTime = (afterTime - beforeTime) / 1000.0;
            System.out.println("Author : " + bookListByAuthor.size());
            System.out.println("검색시간 : " + secDiffTime + "초");
        }

    }
}
