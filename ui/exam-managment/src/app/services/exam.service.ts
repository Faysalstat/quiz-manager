import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quiz } from '../model/model';
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
}
