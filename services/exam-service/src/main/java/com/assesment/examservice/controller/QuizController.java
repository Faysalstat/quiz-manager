package com.assesment.examservice.controller;


import com.assesment.examservice.dto.ExamResultDto;
import com.assesment.examservice.dto.QuizDTO;
import com.assesment.examservice.dto.ResponseDTO;
import com.assesment.examservice.dto.ResultsDTO;
import com.assesment.examservice.service.QuestionService;
import com.assesment.examservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class QuizController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizDTO> add(@RequestBody QuizDTO quizDTO) {
        return ResponseEntity.ok(this.quizService.addQuiz(quizDTO));
    }

    //update quiz

    @PostMapping("/update")
    public ResponseEntity<QuizDTO> update(@RequestBody QuizDTO quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/getall")
    public ResponseEntity<List<QuizDTO>> quizzes() {

        return ResponseEntity.ok(quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping
    public QuizDTO quiz(@RequestParam("id") Long qid) {
        return this.quizService.getQuiz(qid);
    }

    //delete the quiz
    @PostMapping("/delete")
    public void delete(@RequestBody QuizDTO quizDTO) {
        this.quizService.deleteQuiz(quizDTO.getId());
    }

    @PostMapping("/submit")
    public ResponseDTO<ExamResultDto> submitResult(@RequestBody ExamResultDto examResultDto) {
        return new ResponseDTO(true,"Result Pubilished",quizService.submitResult(examResultDto));
    }

    @GetMapping("/result")
    public ResponseDTO<ResultsDTO> getResult(@RequestParam("userId") Long id) {
        return new ResponseDTO(true,"Result Pubilished",quizService.getAllResult(id));
    }
}
