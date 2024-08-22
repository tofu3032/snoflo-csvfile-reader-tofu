import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import csv.CsvUtils;
import library.BookDataGenerator;
import library.LibraryService;
import model.Book;

public class App {

    public static int count;
    public static void main(String[] args) throws IOException {

        // BookDataGenerator bookDataGenerator = new BookDataGenerator();
        // bookDataGenerator.generateCSV("library-management/src/csv/library.csv");

        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt();

        
        LibraryService libraryService = new LibraryService(new BookDataGenerator());
        // File file = new File("src/library.csv");
        // file.setReadOnly();
        System.out.println("-----------------------------");

        // List<String[]> data = Arrays.asList(new String[]{"dbwlsdn","ddd"}, new String[]{"유진우", "dddd"});
        // CsvUtils.writeCsv("src/library.csv", data);

        long beforeTime = System.currentTimeMillis();
        List<Book> bookListByAuthor = libraryService.findBookByAuthor("강진우");
        // System.out.println("bookListByAuthor : " + bookListByAuthor);
        System.out.println("size : " + bookListByAuthor.size());
        long afterTime = System.currentTimeMillis();

        long secDiffTime = (afterTime - beforeTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
        System.out.println(simpleDateFormat.format(secDiffTime));
        System.out.println("secDiffTime : " + secDiffTime);

    }
}
