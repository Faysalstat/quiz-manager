import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserHomeComponent } from './user-home/user-home.component';
import { BrowserModule } from '@angular/platform-browser';

const routes: Routes = [
  {path: '',component: UserHomeComponent},
];

@NgModule({
  declarations: [UserHomeComponent],
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forChild(routes)
  ]
})
export class UserModule { }
