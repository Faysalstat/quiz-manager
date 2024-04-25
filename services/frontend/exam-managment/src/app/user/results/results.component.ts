import { Component, OnInit } from '@angular/core';
import { ExamService } from 'src/app/services/exam.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {
  results:any[]=[];
  constructor(
    private examService:ExamService
  ) { }

  ngOnInit(): void {
    this.getAllResultByUser();
  }

  getAllResultByUser(){
    let userId = localStorage.getItem("userId")||"";
    this.examService.getAllResultByUserId(userId).subscribe({
      next:(res)=>{
        console.log(res);
        this.results = res.body;
      }
    })
  }

}
