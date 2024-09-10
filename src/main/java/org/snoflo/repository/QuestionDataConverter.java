package org.snoflo.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.snoflo.dto.CsvFileDto;
import org.snoflo.model.Question;

public class QuestionDataConverter implements DataConverter<Question> {

	private List<String[]> dataOfCsvFile;
	private List<Question> conversionData;
	private CsvFileReader csvFileReader;
	private CsvFileDto csvFileDto;
	private String csvFile; // 추후 dto로 변경

	public QuestionDataConverter(CsvFileReader csvFileReader, CsvFileDto csvFileDto) {
		this.csvFileDto = csvFileDto;
		this.csvFileReader = csvFileReader;
		this.dataOfCsvFile = csvFileReader.readCsvFile(csvFileDto.getCsvFile());
	}

	@Override
	public List<Question> convertData() throws IOException {
		// this.stringArrays = csvFileReader.readCsvFile(csvFile);
		// this.conversionData = dataOfCsvFile.stream().map(row ->
		// createDomainFromRow(row))
		// .collect(Collectors.toList());
		this.conversionData = dataOfCsvFile.stream().map(row -> new Question(Integer.parseInt(row[0]), row[1], row[2]))
				.collect(Collectors.toList());
		return conversionData;
	}

	@Override
	public Question createDomainFromRow(String[] row) {
		return new Question(Integer.parseInt(row[0]), row[1], row[2]);
	}

	@Override
	public List<Question> getData() {
		return this.conversionData;
	}

}