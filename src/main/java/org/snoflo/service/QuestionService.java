package org.snoflo.service;

import java.util.List;

import org.snoflo.dto.CsvFileDto;
import org.snoflo.model.Question;
import org.snoflo.repository.CsvFileReader;
import org.snoflo.repository.CsvFileReaderImpl;
import org.snoflo.repository.DataConverter;

public class QuestionService implements CsvFileService<Question>{

    private DataConverter<Question> dataConverter;
    private CsvFileDto csvFileDto;
    
    public QuestionService (CsvFileDto csvFileDto) {
        this.dataConverter = new QuestionDataConverter(new CsvFileReaderImpl(), csvFileDto);
        this.csvFileDto = csvFileDto;
    }

    // 추후 옵서녈 도입
	@Override
	public Question findConceptById(int id) {
        List<Question> list = dataConverter.getData();

        for (Question concept : list) {
            if (concept.getId() == id) {
                return concept;
            }
        }
        return null;
	}

}
