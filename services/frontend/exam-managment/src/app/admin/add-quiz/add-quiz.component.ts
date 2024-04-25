import { Component, OnInit } from '@angular/core';
import { Category, Question, Quiz } from 'src/app/model/model';
import { CategoryService } from 'src/app/services/category-service.service';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {
  quizModel:Quiz;
  categoryList:Category[] = [];
  questionModel:Question = new Question();
  questionList: Question[] = [];
  constructor(
    private categoryService:CategoryService,
    private examService:ExamService
  ) {
    this.quizModel = new Quiz();
  }

  ngOnInit(): void {
    this.getAllCategory()
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
    this.quizModel.questions = this.questionList;
    this.quizModel.numberOfQuestions = this.questionList.length
    this.examService.addQuiz(this.quizModel).subscribe({
      next:(res)=>{
        console.log(res);
      }
    })
  }
}
