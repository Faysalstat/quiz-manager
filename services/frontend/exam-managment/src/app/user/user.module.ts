import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserHomeComponent } from './user-home/user-home.component';
import { BrowserModule } from '@angular/platform-browser';
import { QuizesComponent } from './quizes/quizes.component';
import { TakeQuizComponent } from './take-quiz/take-quiz.component';
import { ResultsComponent } from './results/results.component';
import { MaterialModule } from 'src/material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  {path: '',component: UserHomeComponent,children:[
    {path:'',component:QuizesComponent},
    {path:"take-quiz/:id",component:TakeQuizComponent},
    {path:"results",component:ResultsComponent},
  ]},
];

@NgModule({
  declarations: [UserHomeComponent, TakeQuizComponent, ResultsComponent,QuizesComponent],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ]
})
export class UserModule { }
