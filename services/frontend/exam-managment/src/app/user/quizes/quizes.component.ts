import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from 'src/app/model/model';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quizes',
  templateUrl: './quizes.component.html',
  styleUrls: ['./quizes.component.css']
})
export class QuizesComponent implements OnInit {
  quizList:Quiz[] = [];
  constructor(
    private examService:ExamService,
    private router:Router, 
  ) { }

  ngOnInit(): void {
    this.getAllQuizes();
  }

  getAllQuizes(){
    this.examService.getAllQuizList().subscribe({
      next:(res)=>{
        console.log(res);
        this.quizList = res;
      }
    })
  }
  takeQuiz(id:any){
    this.router.navigate(['user/take-quiz',id]);
  }
}
