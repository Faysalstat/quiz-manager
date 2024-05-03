import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from 'src/app/model/model';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent implements OnInit {
  quizList: Quiz[] = [];
  constructor(private router: Router, private examService: ExamService) {}

  ngOnInit(): void {
    this.getAllQuizes();
  }
  getAllQuizes() {
    this.examService.getAllQuizList().subscribe({
      next: (res) => {
        this.quizList = res;
        console.log(res);
      },
    });
  }
  createQuiz() {
    this.router.navigate(['admin/add-quiz']);
  }
  edit(quiz:any) {
    this.router.navigate(["edit-quiz",quiz.id])
  }

  delete(quiz: any) {
    this.examService.deleteQuiz(quiz).subscribe({
      next: (res) => {
        alert('Quiz Deleted');
        this.getAllQuizes();
      },
      error: (err) => {},
    });
  }
}
