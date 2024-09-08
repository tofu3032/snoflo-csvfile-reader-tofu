package org.snoflo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReadTest {

    public static List<String> getCsvFileName(String directory) throws IOException {

        // 특정 디렉토리 경로 지정
        Path dirPath = Paths.get(directory);
        
        return Files.list(dirPath)
        .filter(Files::isRegularFile)
        .filter(path -> path.toString().endsWith(".csv"))
        .map(path -> path.getFileName().toString())
        .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        try {
			List<String> csvFiles = getCsvFileName("/home/omelet1/dev2/library-management/src/main/resources/csv");
            csvFiles.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
