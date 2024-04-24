package com.assesment.examservice.serviceImp;

import com.assesment.examservice.dto.CategoryDto;
import com.assesment.examservice.dto.QuestionDTO;
import com.assesment.examservice.dto.QuizDTO;
import com.assesment.examservice.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Override
    public QuestionDTO addQuestion(QuestionDTO question) {
        return null;
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO question) {
        return null;
    }

    @Override
    public List<QuestionDTO> getQuestions() {
        return null;
    }

    @Override
    public QuestionDTO getQuestion(Long questionId) {
        return null;
    }

    @Override
    public List<QuestionDTO> getQuestionsByQuizId(Long quizId) {
        return null;
    }

    @Override
    public void deleteQuestion(Long quesId) {

    }

    @Override
    public QuestionDTO get(Long questionsId) {
        return null;
    }
}
