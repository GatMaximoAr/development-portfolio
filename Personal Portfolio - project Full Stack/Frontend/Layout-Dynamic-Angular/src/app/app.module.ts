import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { NgxSpinnerModule } from 'ngx-spinner';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AngularFireDatabaseModule } from '@angular/fire/compat/database';
import { AngularFireStorageModule } from '@angular/fire/compat/storage';

import { interceptorProvider } from './services/Auth/interceptor.service';


import { NavbarComponent } from './components/navbar/navbar.component';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { ExprienciaComponent } from './components/exp/expriencia/expriencia.component';
import { AcordeonSkilsProyectosComponent } from './components/acordeon-skils-proyectos/acordeon-skils-proyectos.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { ExperienciaItemComponent } from './components/exp/expriencia/experiencia-item/experiencia-item.component'; 
import { AddItemComponent } from './components/exp/expriencia/add-item/add-item.component'; 
import { UpdateItemComponent } from './components/exp/expriencia/update-item/update-item.component';
import { LoginComponent } from './components/login/login.component';
import { EducacionItemComponent } from './components/educacion/educacion-item/educacion-item.component';
import { SkillsComponent } from './components/acordeon-skils-proyectos/skills/skills.component';
import { ProyectosComponent } from './components/acordeon-skils-proyectos/proyectos/proyectos.component';
import { AddItemEduComponent } from './components/educacion/add-item-edu/add-item-edu.component';
import { UpdateItemEduComponent } from './components/educacion/update-item-edu/update-item-edu.component';
import { AcercaAddComponent } from './components/acerca-de/acerca-add/acerca-add.component';
import { AcercaUpdateComponent } from './components/acerca-de/acerca-update/acerca-update.component';
import { ItemProyectosComponent } from './components/acordeon-skils-proyectos/proyectos/item-proyectos/item-proyectos.component';
import { ProyectoAddComponent } from './components/acordeon-skils-proyectos/proyectos/proyecto-add/proyecto-add.component';
import { ProyectoUpdateComponent } from './components/acordeon-skils-proyectos/proyectos/proyecto-update/proyecto-update.component';
import { RegistroComponent } from './components/registro/registro.component';
import { SkillItemComponent } from './components/acordeon-skils-proyectos/skills/skill-item/skill-item.component';
import { UserComponent } from './components/user/user/user.component';
import { NotFoundComponent } from './components/not-found/not-found.component';







@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AcercaDeComponent,
    ExprienciaComponent,
    AcordeonSkilsProyectosComponent,
    EducacionComponent,
    HomeComponent,
    FooterComponent,
    ExperienciaItemComponent,
    AddItemComponent,
    UpdateItemComponent,
    LoginComponent,
    EducacionItemComponent,
    SkillsComponent,
    ProyectosComponent,
    AddItemEduComponent,
    UpdateItemEduComponent,
    AcercaAddComponent,
    AcercaUpdateComponent,
    ItemProyectosComponent,
    ProyectoAddComponent,
    ProyectoUpdateComponent,
    RegistroComponent,
    SkillItemComponent,
    UserComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    AngularFireDatabaseModule,
    AngularFireStorageModule,
    BrowserAnimationsModule,
    NgxSpinnerModule
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
