package com.assesment.examservice.serviceImp;

import com.assesment.examservice.client.CategoryFeignClient;
import com.assesment.examservice.dto.*;
import com.assesment.examservice.entity.ExamResult;
import com.assesment.examservice.entity.Question;
import com.assesment.examservice.entity.Quiz;
import com.assesment.examservice.mapper.ExamResultMapper;
import com.assesment.examservice.mapper.QuizMapper;
import com.assesment.examservice.repository.ExamResultRepo;
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
    private ExamResultMapper examResultMapper;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ExamResultRepo examResultRepo;

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
        List<Quiz> quizList = quizRepository.findAll();
        List<QuizDTO> quizDtoList = new ArrayList<>();
        if(!quizList.isEmpty()){
            for(Quiz quiz:quizList){
                quizDtoList.add(quizMapper.toQuizDto(quiz));
            }
        }
        return quizDtoList;
    }

    @Override
    public QuizDTO getQuiz(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        QuizDTO quizDTO = quizMapper.toQuizDto(quiz);
        quizDTO.setCategoryDto(categoryFeignClient.getCategory(quiz.getCategoryId()));
        List<Question> questionList = questionRepository.findAllByQuizId(quizId);
        for(Question question:questionList){
            quizDTO.getQuestions().add(quizMapper.toDto(question));
        }
        return quizDTO;
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
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

    @Override
    public ExamResultDto submitResult(ExamResultDto examResultDto) {
        return examResultMapper.toDto(examResultRepo.save(examResultMapper.toEntity(examResultDto)));
    }

    @Override
    public List<ResultsDTO> getAllResult(Long userId) {
        List<ExamResult> examResults = examResultRepo.findByUserId(userId);
        List<ResultsDTO> examResultDtos = new ArrayList<>();
        for(ExamResult examResult:examResults){
            ResultsDTO newResult = examResultMapper.toResponseDto(examResult);
            newResult.setQuiz(quizRepository.findById(examResult.getQuizId()).orElseThrow());
            examResultDtos.add(newResult);

        }

        return examResultDtos;
    }
}
