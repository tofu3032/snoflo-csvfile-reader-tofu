import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import csv.CsvUtils;
import library.BookDataGenerator;
import library.LibraryService;
import model.Book;

public class App {

    public static void main(String[] args) throws IOException {

        // BookDataGenerator bookDataGenerator = new BookDataGenerator();
        // bookDataGenerator.generateCSV("library-management/src/csv/library.csv");
       
        LibraryService libraryService = new LibraryService(new BookDataGenerator());
       
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
