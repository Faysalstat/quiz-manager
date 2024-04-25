package com.assesment.examservice.serviceImp;

import com.assesment.examservice.client.CategoryFeignClient;
import com.assesment.examservice.dto.CategoryDto;
import com.assesment.examservice.dto.QuestionDTO;
import com.assesment.examservice.dto.QuizDTO;
import com.assesment.examservice.entity.Question;
import com.assesment.examservice.entity.Quiz;
import com.assesment.examservice.mapper.QuizMapper;
import com.assesment.examservice.repository.QuestionRepository;
import com.assesment.examservice.repository.QuizRepository;
import com.assesment.examservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImp implements QuizService {
    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryFeignClient categoryFeignClient;

    @Override
    public QuizDTO addQuiz(QuizDTO quizDTO) {
        Quiz newQuiz = quizMapper.toQuizCreateEntity(quizDTO);
        List<QuestionDTO> questiondtos = quizDTO.getQuestions();
        List<Question> questions = new ArrayList<>();
        Quiz createdQuiz = quizRepository.save(newQuiz);
        for(QuestionDTO dto:questiondtos){
            Question question = quizMapper.toEntity(dto);
            question.setQuizId(createdQuiz.getId());
            questions.add(question);

        }
        questionRepository.saveAll(questions);
        QuizDTO createdQuizDto = quizMapper.toQuizDto(createdQuiz);
        createdQuizDto.setCategoryDto(categoryFeignClient.getCategory(createdQuiz.getCategoryId()));
        List<Question> newQuestions = questionRepository.findAllByQuizId(createdQuiz.getId());
        for (Question qus:newQuestions) {
            createdQuizDto.getQuestions().add(quizMapper.toDto(qus));
        }
        return createdQuizDto;
    }

    @Override
    public QuizDTO updateQuiz(QuizDTO quiz) {
        return null;
    }

    @Override
    public List<QuizDTO> getQuizzes() {
        return null;
    }

    @Override
    public QuizDTO getQuiz(Long quizId) {
        return null;
    }

    @Override
    public void deleteQuiz(Long quizId) {

    }

    @Override
    public List<QuizDTO> getQuizzesOfCategory(CategoryDto category) {
        return null;
    }

    @Override
    public List<QuizDTO> getActiveQuizzes() {
        return null;
    }

    @Override
    public List<QuizDTO> getActiveQuizzesOfCategory(CategoryDto c) {
        return null;
    }
}
