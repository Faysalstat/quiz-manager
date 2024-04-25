import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ExamResponse, ExamResult, Question, Quiz } from 'src/app/model/model';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-take-quiz',
  templateUrl: './take-quiz.component.html',
  styleUrls: ['./take-quiz.component.css'],
})
export class TakeQuizComponent implements OnInit {
  quizId!: number;
  questions:ExamResponse[] = [];
  quiz: Quiz = new Quiz();
  examresponse:ExamResult = new ExamResult();
  constructor(
    private activatedRoute: ActivatedRoute,
    private examService: ExamService,
    private router:Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe({
      next: (res) => {
        console.log(res);
        this.quizId = res['id'];
        this.examresponse.quizId = this.quizId;
        this.examresponse.userId = localStorage.getItem("userId") || "";
        
        this.getQuizDetails();
      },
    });
  }
  getQuizDetails() {
    this.examService.getQuizDetails(this.quizId).subscribe({
      next:(res)=>{
        this.quiz = res;
        let questions = res.questions;
        questions.map((qus:any)=>{
          this.questions.push({
            content:qus.content,
            option1:qus.option1,
            option2:qus.option2,
            option3:qus.option3,
            option4:qus.option4,
            answer:qus.answer,
            givenAnswer:""
          })
        })
        this.examresponse.noOfQuestions = questions.length;
        console.log(res)
      }
    })
  }
  submitAns(){
    console.log(this.questions);
    this.examresponse.correctAnswer = 0;
    this.questions.map((question)=>{
      if(question.answer==question.givenAnswer){
        this.examresponse.correctAnswer++
      }
    })
    console.log(this.examresponse);
    this.examService.submitExamPaper(this.examresponse).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigate(['results']);
      }
    })


    
  }
}
