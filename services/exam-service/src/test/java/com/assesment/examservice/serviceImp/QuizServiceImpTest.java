package com.assesment.examservice.serviceImp;

import com.assesment.examservice.dto.ExamResultDto;
import com.assesment.examservice.dto.GradeDto;
import com.assesment.examservice.service.QuizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class QuizServiceImpTest {
    @Autowired
    private QuizService quizService;
    @Test
    void calculateResult() {
        ExamResultDto examResult = new ExamResultDto(20, 15); // 20 questions, 15 correct answers

        // When
        GradeDto grade = quizService.calculateResult(examResult);

        // Then
        assertEquals(75.0, grade.getMark(), 0.01); // 15/20 * 100 = 75
        assertEquals('B', grade.getGrade()); // Assuming 75% corresponds to grade B
    }

    @Test
    void testCalculateResultInvalid() {
        // Given
        ExamResultDto examResult = new ExamResultDto(20, 15); // 20 questions, 15 correct answers

        // When
        GradeDto grade = quizService.calculateResult(examResult);

        // Then
        assertEquals(75.0, grade.getMark(), 0.01); // 15/20 * 100 = 75
        assertEquals('C', grade.getGrade()); // Assuming 75% corresponds to grade B
    }
}