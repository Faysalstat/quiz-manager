import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExamResult, Quiz } from '../model/model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  private apiUrl = 'http://localhost:8000/exam'; // Change this URL to match your actual API URL

  constructor(private http: HttpClient) { }

  addQuiz(quizModel: Quiz): Observable<any> {
    return this.http.post(this.apiUrl, quizModel);
  }
  updateQuiz(quizModel: Quiz): Observable<any> {
    return this.http.post(this.apiUrl+"/update", quizModel);
  }
  deleteQuiz(quizModel:Quiz):Observable<any>{
    return this.http.post(this.apiUrl+"/delete",quizModel);
  }

  getAllQuizList():Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl+"/getall");
  }

  getQuizDetails(id:number):Observable<any>{
    let params = new HttpParams();
    params = params.append('id',id);
    return this.http.get(this.apiUrl,{params:params});
  }

  submitExamPaper(response:ExamResult):Observable<any>{
    return this.http.post(this.apiUrl+"/submit",response);
  }

  getAllResultByUserId(userId:any):Observable<any>{
    let params = new HttpParams();
    params = params.append('userId',userId);
    return this.http.get(this.apiUrl+"/result",{params:params});
  }
}
