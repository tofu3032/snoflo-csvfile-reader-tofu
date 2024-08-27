package org.snoflo.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CsvFileManager extends AbstractCsvFileManager {

    private final Random random;

    public CsvFileManager(Random random) {
        super();
        this.random = random;
    }

    public CsvFileManager(String csvfile, int row, Random random) {
        super(csvfile, row);
        this.random = random;
    }

    @Override
    public void generateCsvFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("ISBN, Title, Author, Year\n");

            for (int i = 0; i < row; i++) {
                String isbn = UUID.randomUUID().toString().substring(0, 13);
                String title = "Book" + random.nextInt(row);
                String author = generateRandomAuthor();
                int year = 1950 + random.nextInt(74);
                writer.write(String.format("%s,%s,%s,%d\n", isbn, title, author, year));
            }
        }
    }

    @Override
    List<String[]> readCsvFile() throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    @Override
    void writeCsvFile(List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }
    }

    private String generateRandomAuthor() {
        String[] FIRST_NAMES = { "유", "김", "이", "박", "최", "나", "강", "국" };
        String[] LAST_NAMES = { "진우", "종철", "승현", "가영", "나영", "다영", "영호", "철수", "미진", "영수", "훈영", "선영", "태연", "설화" };

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + lastName;
    }

}
