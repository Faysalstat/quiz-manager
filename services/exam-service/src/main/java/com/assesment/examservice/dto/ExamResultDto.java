package com.assesment.examservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ExamResultDto {
    private long id;

    private long quizId;

    private long userId;

    private Integer noOfQuestions;

    private Integer correctAnswer;
}
