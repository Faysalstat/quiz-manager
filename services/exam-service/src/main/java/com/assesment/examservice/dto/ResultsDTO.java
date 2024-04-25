package com.assesment.examservice.dto;

import com.assesment.examservice.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResultsDTO {

    private Quiz quiz;

    private long userId;

    private Integer noOfQuestions;

    private Integer correctAnswer;
}
