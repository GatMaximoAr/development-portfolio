import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AcercaService } from 'src/app/services/Acerca-de/acerca.service';
import { TokenService } from 'src/app/services/Auth/token.service';
import { StorageService } from 'src/app/services/storage.service';
import {Acerca} from '../../../models/Acerca';

@Component({
  selector: 'app-acerca-add',
  templateUrl: './acerca-add.component.html',
  styleUrls: ['./acerca-add.component.css']
})
export class AcercaAddComponent implements OnInit {


  formularioAcercaDe: FormGroup;
  envio:boolean = false
  formularioEnviado:boolean = false
  previewEnvio:Acerca
  img_perfil: any;
  img_fondo: any;

  constructor(private _builder:FormBuilder, private acercaService:AcercaService,
    private router:Router, private storage:StorageService, private tokenService:TokenService) { 
    
    this.formularioAcercaDe = this._builder.group({
      nombre_usuario: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],

      apellido_usuario: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],

      imagen: ['', Validators.required],

      sobre_usuario: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],

      ocupacion: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],

      img_portada: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  onSubmit(valor: Acerca) {
    //console.log(valor)
    this.previewEnvio = valor
    this.previewEnvio.imagen = this.img_perfil
    this.previewEnvio.img_portada = this.img_fondo
    this.formularioEnviado = !this.formularioEnviado
    }

    capturar_img_perfil(event:any) {
      let imagen = event.target.files[0]
      let reader = new FileReader()
      reader.readAsDataURL(imagen)
      reader.onloadend = () => {
        this.img_perfil = reader.result!
        //console.log(this.img_perfil)
      }
    }
  
    capturar_img_forndo(event:any) {
      let imagen = event.target.files[0]
      let reader = new FileReader()
      reader.readAsDataURL(imagen)
      reader.onloadend = () => {
        //console.log(reader.result)
        this.img_fondo = reader.result!
      }
    }

    postAcerca(acerca:Acerca) {
      this.acercaService.postAcerca(acerca)
      .subscribe(resp => {
        //console.log(resp)
        window.location.reload()
      })
      this.goHome()
    }
    

  resetForm() {
    this.formularioEnviado = !this.formularioEnviado
    this.formularioAcercaDe.reset()
      
  }

  enviarform() {
    this.envio = !this.envio
    this.storage.subirImagen(this.img_perfil, "perfil", "acerca-de/")
    .then(url_perfil => {
      this.previewEnvio.imagen = url_perfil
      this.storage.subirImagen(this.img_fondo, "fondo", "acerca-de/").then(url_fondo => {
        this.previewEnvio.img_portada = url_fondo

        this.postAcerca(this.previewEnvio)
      })
    })
    
    //this.postAcerca(this.previewEnvio)
      
  }
  
  goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }
}
