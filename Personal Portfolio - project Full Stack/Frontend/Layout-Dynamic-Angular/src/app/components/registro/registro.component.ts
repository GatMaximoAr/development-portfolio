import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NuevoUsuario } from 'src/app/models/NuevoUsuario';
import { AuthService } from 'src/app/services/Auth/auth.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  formRegistro:FormGroup
  errorRegistro:boolean = false
  roles:string[] = ["admin"]
  mensajeError:string

  constructor(private _builder:FormBuilder, private autService:AuthService,
    private route:Router) { 
    this.formRegistro = this._builder.group({

      "nombreUsuario": ['', [Validators.required, Validators.minLength(4)]],
      "email": ['', [Validators.required, Validators.email]],
      "password": ['', [Validators.required, Validators.minLength(4), Validators.maxLength(30)]]
    })
  }

  ngOnInit(): void {
  }

  onRegistro(valor:NuevoUsuario):void {
    this.errorRegistro = false
    valor.roles = this.roles
    this.nuevoUsuario(valor)
  }

  nuevoUsuario(usuario:NuevoUsuario):void {
    this.autService.singUp(usuario)
    .subscribe(resp => {
      console.log(resp)
      alert("Nuevo usuario creado")
      this.route.navigate(['login'])
    }, err => {
      this.errorRegistro = true

      this.mensajeError = err.error.mensaje
    })
  }

}
