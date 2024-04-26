package com.assesment.examservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ExamResultDto {
    private long id;

    private long quizId;

    private long userId;

    private Integer noOfQuestions;

    private Integer correctAnswer;

    public ExamResultDto() {
    }

    public ExamResultDto(long id, long quizId, long userId, Integer noOfQuestions, Integer correctAnswer) {
        this.id = id;
        this.quizId = quizId;
        this.userId = userId;
        this.noOfQuestions = noOfQuestions;
        this.correctAnswer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(Integer noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
