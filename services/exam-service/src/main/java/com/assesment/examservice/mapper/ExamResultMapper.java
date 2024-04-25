package com.assesment.examservice.mapper;

import com.assesment.examservice.dto.ExamResultDto;
import com.assesment.examservice.dto.ResultsDTO;
import com.assesment.examservice.entity.ExamResult;
import org.springframework.stereotype.Component;

@Component
public class ExamResultMapper {
    public ExamResultDto toDto(ExamResult entity) {
        ExamResultDto dto = new ExamResultDto();
        dto.setId(entity.getId());
        dto.setQuizId(entity.getQuizId());
        dto.setUserId(entity.getUserId());
        dto.setNoOfQuestions(entity.getNoOfQuestions());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        return dto;
    }

    public ResultsDTO toResponseDto(ExamResult entity) {
        ResultsDTO dto = new ResultsDTO();
        dto.setUserId(entity.getUserId());
        dto.setNoOfQuestions(entity.getNoOfQuestions());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        return dto;
    }

    public static ExamResult toEntity(ExamResultDto dto) {
        ExamResult entity = new ExamResult();
        entity.setQuizId(dto.getQuizId());
        entity.setUserId(dto.getUserId());
        entity.setNoOfQuestions(dto.getNoOfQuestions());
        entity.setCorrectAnswer(dto.getCorrectAnswer());
        return entity;
    }
}
