package com.assesment.examservice.dto;

public class GradeDto {
    private double mark;
    private char grade;

    public GradeDto() {
    }

    public GradeDto(double mark, char grade) {
        this.mark = mark;
        this.grade = grade;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
