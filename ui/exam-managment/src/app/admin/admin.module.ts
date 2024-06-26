import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { HttpClientModule } from '@angular/common/http';
import { CategoriesComponent } from './categories/categories.component';
import { MaterialModule } from 'src/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { QuestionsComponent } from './questions/questions.component';
import { QuizComponent } from './quiz/quiz.component';
import { AddQuizComponent } from './add-quiz/add-quiz.component';

const routes: Routes = [
  {path: '',component: AdminHomeComponent,children:[
    {path:"categories",component:CategoriesComponent},
    {path:"questions",component:QuestionsComponent},
    {path:"quiz",component:QuizComponent},
    {path:"add-quiz",component:AddQuizComponent},
  ]},
  
];

@NgModule({
  declarations: [AdminHomeComponent,CategoriesComponent, QuestionsComponent, QuizComponent,AddQuizComponent],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ]
})
export class AdminModule { }
