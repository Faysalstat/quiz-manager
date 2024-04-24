package com.assesment.examservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 5000)
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    @Transient
    private  String givenAnswer;
    private Long quizId;


}
