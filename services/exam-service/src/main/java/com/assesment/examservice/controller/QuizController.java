package com.assesment.examservice.controller;


import com.assesment.examservice.dto.QuizDTO;
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

    @PutMapping
    public ResponseEntity<QuizDTO> update(@RequestBody QuizDTO quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping
    public ResponseEntity<?> quizzes() {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("/{qid}")
    public QuizDTO quiz(@PathVariable("qid") Long qid) {
        return this.quizService.getQuiz(qid);
    }

    //delete the quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }
//
//    @GetMapping("/category/{cid}")
//    public List<QuizDTO> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
//        Category category = new Category();
//        category.setCid(cid);
//        return this.quizService.getQuizzesOfCategory(category);
//    }
//
//    //get active quizzes
//    @GetMapping("/active")
//    public List<Quiz> getActiveQuizzes() {
//        return this.quizService.getActiveQuizzes();
//    }
//
//    //get active quizzes of category
//    @GetMapping("/category/active/{cid}")
//    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
//        Category category = new Category();
//        category.setCid(cid);
//        return this.quizService.getActiveQuizzesOfCategory(category);
//    }
}
