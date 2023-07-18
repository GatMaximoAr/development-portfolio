import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './components/exp/expriencia/add-item/add-item.component'; 
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { UpdateItemComponent } from './components/exp/expriencia/update-item/update-item.component';
import { AdminGuard as guard } from './guards/admin.guard';
import { AddItemEduComponent } from './components/educacion/add-item-edu/add-item-edu.component';
import { UpdateItemEduComponent } from './components/educacion/update-item-edu/update-item-edu.component';
import { AcercaAddComponent } from './components/acerca-de/acerca-add/acerca-add.component';
import { AcercaUpdateComponent } from './components/acerca-de/acerca-update/acerca-update.component';
import { ProyectoAddComponent } from './components/acordeon-skils-proyectos/proyectos/proyecto-add/proyecto-add.component';
import { ProyectoUpdateComponent } from './components/acordeon-skils-proyectos/proyectos/proyecto-update/proyecto-update.component';
import { RegistroComponent } from './components/registro/registro.component';
import { UserComponent } from './components/user/user/user.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {path: 'portfolio/:usuario', component: UserComponent, children:[

    {path:'', component:HomeComponent},
    
    {path: 'add-item-exp', component: AddItemComponent, canActivate: [guard], data: {expectedRol:['admin']}},
    
    {path: 'update-item-exp/:id', component: UpdateItemComponent, canActivate: [guard], data: {expectedRol:['admin']} },

    {path: 'add-item-edu', component: AddItemEduComponent, canActivate: [guard], data: {expectedRol:['admin']}},

    {path: 'update-item-edu/:id', component: UpdateItemEduComponent, canActivate: [guard], data: {expectedRol:['admin']}},

    {path: 'add-acerca' , component: AcercaAddComponent, canActivate: [guard], data: {expectedRol:['admin']}},

    {path: 'update-acerca/:id', component: AcercaUpdateComponent, canActivate: [guard], data: {expectedRol:['admin']}},
    
    {path: 'add-proyecto', component: ProyectoAddComponent, canActivate: [guard], data: {expectedRol:['admin']}},
    
    {path: 'update-proyecto/:id', component:ProyectoUpdateComponent, canActivate: [guard], data: {expectedRol:['admin']}}
    
  ]

},
  
  {path: 'login', component: LoginComponent},

  {path: 'singUp', component: RegistroComponent},

  {path: 'not-found', component: NotFoundComponent},

  {path: '', redirectTo: 'login', pathMatch: 'full' },

  {path: '**', redirectTo: 'not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
