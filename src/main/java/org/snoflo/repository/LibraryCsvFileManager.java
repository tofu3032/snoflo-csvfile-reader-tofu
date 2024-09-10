package org.snoflo.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LibraryCsvFileManager extends AbstractCsvFileManager {

    public LibraryCsvFileManager(String csvFile, int row) {
        super(csvFile, row);
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
    public List<String[]> readCsvFile() throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (String value : values) {
                    System.out.println("value " + value);
                }
                data.add(values);
            }
        }
        return data;
    }

    @Override
    public void writeCsvFile(List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] row : data) {
                writer.write(String.join(",", row) + "\n");
            }
        }
    }

    private String generateRandomAuthor() {
        /*
         * String[] FIRST_NAMES = { "유", "김", "이", "박", "최", "나", "강", "국" };
         * String[] LAST_NAMES = { "진우", "종철", "승현", "가영", "나영", "다영", "영호", "철수", "미진",
         * "영수", "훈영", "선영", "태연", "설화" };
         */

        String[] FIRST_NAMES = { "John", "Michael", "James", "David", "Robert", "Emily", "Emma", "Olivia", "Sophia",
                "Isabella", "Daniel", "Matthew", "Ava", "Charlotte" };
        String[] LAST_NAMES = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
                "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson" };

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

	@Override
	public String toString() {
		return "LibraryCsvFileManager []";
	}

    
}
