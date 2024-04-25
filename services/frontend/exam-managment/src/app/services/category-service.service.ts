import { Injectable } from '@angular/core';
import { Category } from '../model/model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private apiUrl = 'http://localhost:8000/category'; // Change this URL to match your actual API URL

  constructor(private http: HttpClient) { }

  addCategory(Category: Category): Observable<Category> {
    return this.http.post<Category>(this.apiUrl, Category);
  }

  getCategoryById(categoryId: number): Observable<Category> {
    return this.http.get<Category>(`${this.apiUrl}/${categoryId}`);
  }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.apiUrl);
  }

  updateCategory(Category: Category): Observable<any> {
    return this.http.put<any>(this.apiUrl + '/', Category);
  }

  deleteCategory(categoryId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${categoryId}`);
  }
}
