import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import csv.CsvUtils;
import model.Book;

public class MemoryUsageTest {
    private static final String CSV_FILE = "src/library.csv";
    private static final Runtime runtime = Runtime.getRuntime();

    // 인스턴스 변수로 data를 선언한 LibraryService
    static class LibraryServiceWithInstanceVar {
        private List<String[]> data;

        public LibraryServiceWithInstanceVar() throws IOException {
            this.data = CsvUtils.readCsv(CSV_FILE);
        }

        public List<Book> findBookByAuthor(String author) {
            return data.stream().skip(1)
                .map(this::createBookFromRow)
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
        }

        private Book createBookFromRow(String[] row) {
            return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
        }
    }

    // 로컬 변수로 data를 사용하는 LibraryService
    static class LibraryServiceWithLocalVar {
        public List<Book> findBookByAuthor(String author) throws IOException {
            List<String[]> data = CsvUtils.readCsv(CSV_FILE);
            return data.stream().skip(1)
                .map(this::createBookFromRow)
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
        }

        private Book createBookFromRow(String[] row) {
            return new Book(row[0], row[1], row[2], Integer.parseInt(row[3]));
        }
    }

    public static void main(String[] args) throws IOException {
        // 인스턴스 변수 버전 테스트
        System.out.println("Testing LibraryService with instance variable:");
        measureMemoryUsage(() -> {
            try {
                LibraryServiceWithInstanceVar service = new LibraryServiceWithInstanceVar();
                service.findBookByAuthor("SomeAuthor");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 로컬 변수 버전 테스트
        System.out.println("\nTesting LibraryService with local variable:");
        measureMemoryUsage(() -> {
            try {
                LibraryServiceWithLocalVar service = new LibraryServiceWithLocalVar();
                service.findBookByAuthor("SomeAuthor");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void measureMemoryUsage(Runnable test) {
        // 가비지 컬렉션 실행
        runtime.gc();
        
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        
        test.run();
        
        // 가비지 컬렉션 실행
        runtime.gc();
        
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        
        System.out.println("Used Memory: " + (usedMemoryAfter - usedMemoryBefore) / 1024 + " KB");
    }
}