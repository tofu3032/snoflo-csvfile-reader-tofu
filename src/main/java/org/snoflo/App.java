package org.snoflo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.snoflo.csv.LibraryCsvFileGenerator;
import org.snoflo.library.LibraryService;
import org.snoflo.model.Book;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("---------------------------------");
        System.out.println("도서관리 프로그램 시작");
        System.out.println("---------------------------------");

        LibraryCsvFileGenerator bookDataGenerator = null;
        LibraryService libraryService = null;
        int row = -1;

        try (Scanner scanner = new Scanner(System.in)) {

            Path rootDir = Paths.get("").toAbsolutePath();
            Path csvFile = rootDir.resolve("library.csv");

            System.out.println("rootDir : " + rootDir);
            System.out.println("csvFile : " + csvFile);
            
            if (Files.notExists(csvFile)) {

                boolean isVaild = false;
                System.out.println("----- csv 생성");
                System.out.println("row를 입력하세요.");

                while (!isVaild) {
                    try {
                        row = Integer.parseInt(scanner.nextLine());
                        isVaild = true;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("정수를 입력해주세요");
                    }

                }
            }

            bookDataGenerator = new LibraryCsvFileGenerator();

            libraryService = new LibraryService();

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
