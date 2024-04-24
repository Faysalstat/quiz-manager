package com.assesment.examservice.mapper;


import com.assesment.examservice.client.CategoryFeignClient;
import com.assesment.examservice.dto.QuestionDTO;
import com.assesment.examservice.dto.QuizDTO;
import com.assesment.examservice.entity.Question;
import com.assesment.examservice.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {


    public QuestionDTO toDto(Question entity){
        if (entity == null) {
            return null;
        }

        QuestionDTO dto = new QuestionDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setOption1(entity.getOption1());
        dto.setOption2(entity.getOption2());
        dto.setOption3(entity.getOption3());
        dto.setOption4(entity.getOption4());
        dto.setAnswer(entity.getAnswer());
        return dto;
    }

    public Question toEntity(QuestionDTO dto){
        if (dto == null) {
            return null;
        }
        Question entity = new Question();
        entity.setContent(dto.getContent());
        entity.setOption1(dto.getOption1());
        entity.setOption2(dto.getOption2());
        entity.setOption3(dto.getOption3());
        entity.setOption4(dto.getOption4());
        entity.setAnswer(dto.getAnswer());
        return entity;
    }



    public QuizDTO toQuizDto(Quiz entity){
        if (entity == null) {
            return null;
        }

        QuizDTO dto = new QuizDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setNumberOfQuestions(entity.getNumberOfQuestions());
        return dto;
    }
    public Quiz toQuizEntity(QuizDTO dto){
        if (dto == null) {
            return null;
        }

        Quiz entity = new Quiz();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setNumberOfQuestions(dto.getNumberOfQuestions());
        entity.setCategoryId(dto.getCategoryDto().getId());
        return entity;
    }

    public Quiz toQuizCreateEntity(QuizDTO dto){
        if (dto == null) {
            return null;
        }

        Quiz entity = new Quiz();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setNumberOfQuestions(dto.getNumberOfQuestions());
        entity.setCategoryId(dto.getCategoryDto().getId());
        return entity;
    }


}
