import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/model';
import { CategoryService } from 'src/app/services/category-service.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categoryModel:Category;
  categoryList:Category[] = [];
  constructor(
    private categoryService:CategoryService
  ) {
    this.categoryModel  = new Category();
   }

  ngOnInit(): void {
    this.getAllCategory();
  }

  getAllCategory(){
    this.categoryService.getAllCategories().subscribe({
      next:(res)=>{
        console.log(res);
        this.categoryList = res;
      }
    })
  }
  submit(){
    this.categoryService.addCategory(this.categoryModel).subscribe({
      next:(res)=>{
        console.log(res);
        this.categoryModel = new Category();
        this.getAllCategory();
      }
    })
  }
}
