package org.snoflo.library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class BookDataGenerator implements Generator {

    private final Random random;

    public BookDataGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean createCSVFile() throws IOException {
        String fileName = "library.csv";
        int row = 100;
        boolean isCreated = true;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("ISBN, Title, Author, Year\n");

            for (int i = 0; i < row; i++) {
                String isbn = UUID.randomUUID().toString().substring(0, 13);
                String title = "Book" + random.nextInt(row);
                String author = generateRandomAuthor();
                int year = 1950 + random.nextInt(74);
                writer.write(String.format("%s,%s,%s,%d\n", isbn, title, author, year));
            }
        }
        return isCreated;
    }

    private String generateRandomAuthor() {
        String[] FIRST_NAMES = { "유", "김", "이", "박", "최", "나", "강", "국" };
        String[] LAST_NAMES = { "진우", "종철", "승현", "가영", "나영", "다영", "영호", "철수", "미진", "영수", "훈영", "선영", "태연", "설화"};

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + lastName;
    }

}
