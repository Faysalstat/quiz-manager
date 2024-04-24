package com.assesment.examservice.dto;

import com.assesment.examservice.entity.Quiz;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Long id;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private QuizDTO quizDTO;
}
