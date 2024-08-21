package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class BookDataGenerator {

    private final String CSV_FILE = "src/library.csv";

    private final Random random;

    private final String[] FIRST_NAMES = { "유", "김", "이", "박", "최", "나", "강", "국" };
    private final String[] LAST_NAMES = { "진우", "종철", "승현", "가영", "나영", "다영", "영호", "철수", "미진", "영수", "훈영", "선영", "태연",
            "설화" };

    public BookDataGenerator() throws IOException {
        this.random = new Random();
        generateCSV(CSV_FILE);
    }

    public void generateCSV(String filename) throws IOException {
        int count = 10000000;

        if (!isCSVExists(filename)) {
            System.out.println("파일을 생성하였습니다.");
            generateCSV(filename, count);
        } else {
            System.out.println("이미 CSV파일이 생성되었습니다.");
        }

    }

    private String generateRandomAuthor() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + lastName;
    }

    private void generateCSV(String filename, int count) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // FileWriter writer = new FileWriter(filename);
            writer.write("ISBN, Title, Author, Year\n");

            for (int i = 0; i < count; i++) {
                String isbn = UUID.randomUUID().toString().substring(0, 13);
                String title = "Book" + random.nextInt(count);
                String author = generateRandomAuthor();
                int year = 1950 + random.nextInt(74);
                writer.write(String.format("%s,%s,%s,%d\n", isbn, title, author, year));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isCSVExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

	public String getCsvFile() {
		return CSV_FILE;
	}


}
