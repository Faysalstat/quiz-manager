package com.assesment.examservice.service;


import com.assesment.examservice.dto.QuestionDTO;
import com.assesment.examservice.entity.Question;
import com.assesment.examservice.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface QuestionService {

     QuestionDTO addQuestion(QuestionDTO question);

     QuestionDTO updateQuestion(QuestionDTO question);

     List<QuestionDTO> getQuestions();

     QuestionDTO getQuestion(Long questionId);

     List<QuestionDTO> getQuestionsByQuizId(Long quizId);

     void deleteQuestion(Long quesId);

     QuestionDTO get(Long questionsId);

}
