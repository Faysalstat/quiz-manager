package com.assesment.examservice.service;


import com.assesment.examservice.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
public interface QuizService {

     QuizDTO addQuiz(QuizDTO quizDTO);

     QuizDTO updateQuiz(QuizDTO quiz);

     List<QuizDTO> getQuizzes();

     QuizDTO getQuiz(Long quizId);

     void deleteQuiz(Long quizId);


     List<QuizDTO> getQuizzesOfCategory(CategoryDto category);

    public List<QuizDTO> getActiveQuizzes();

    public List<QuizDTO> getActiveQuizzesOfCategory(CategoryDto c);

    ExamResultDto submitResult(ExamResultDto examResultDto);

    public List<ResultsDTO> getAllResult(Long userId);
}
