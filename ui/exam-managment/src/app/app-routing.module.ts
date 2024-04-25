import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserAuthGuard } from './auth/user-auth.guard';
import { AdminAuthGuard } from './auth/admin-auth.guard';

const routes: Routes = [
  {path: '',component: WelcomeComponent},
  { path: 'auth',  loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: 'user',canActivate:[UserAuthGuard], loadChildren: () => import('./user/user.module').then(m => m.UserModule) },
  { path: 'admin',canActivate:[AdminAuthGuard], loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
