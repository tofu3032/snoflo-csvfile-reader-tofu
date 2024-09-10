package org.snoflo.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.dto.CsvFileDto;
import org.snoflo.model.Question;

public class QuestionCsvFileReader implements CsvFileReader {

	@Override
	public List<String[]> readCsvFile(String csvFile) {

		List<String[]> list = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {

			String line;
			reader.readLine(); // 첫 줄 없애기

			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				list.add(values);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		return list;
	}

}