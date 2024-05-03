import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category, Question, Quiz } from 'src/app/model/model';
import { CategoryService } from 'src/app/services/category-service.service';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {
  quizModel:Quiz;
  categoryList:Category[] = [];
  questionModel:Question = new Question();
  questionList: Question[] = [];
  quizId!: number;
  constructor(
    private categoryService:CategoryService,
    private examService:ExamService,
    private activatedRoute:ActivatedRoute
  ) {
    this.quizModel = new Quiz();
  }
  ngOnInit(): void {
    this.getAllCategory()
    this.activatedRoute.params.subscribe({
      next: (res) => {
        console.log(res);
        this.quizId = res['id'];
        this.getQuizDetails();
      },
    });
  }
  getQuizDetails() {
    this.examService.getQuizDetails(this.quizId).subscribe({
      next:(res)=>{
        this.quizModel = res;
        this.questionList =res.questions;
      }
    })
  }
  getAllCategory(){
    this.categoryService.getAllCategories().subscribe({
      next:(res)=>{
        console.log(res);
        this.categoryList = res;
      }
    })
  }
  addQuestion(){
    this.questionList.push(this.questionModel);
    this.questionModel = new Question();
  }
  submit(){
    this.quizModel.questions = [];
    this.quizModel.questions = this.questionList;
    this.quizModel.numberOfQuestions = this.questionList.length
    this.examService.updateQuiz(this.quizModel).subscribe({
      next:(res)=>{
        alert("Quiz Updated");
        console.log(res);
      }
    })
  }

  selectQuestion(index:any){
    this.questionModel = this.questionList[index];
    this.questionList.splice(index, 1);
  }

}
