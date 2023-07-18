import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/models/Educacion';
import { TokenService } from 'src/app/services/Auth/token.service';
import { EducacionServiceService } from 'src/app/services/Educacion/educacion-service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-add-item-edu',
  templateUrl: './add-item-edu.component.html',
  styleUrls: ['./add-item-edu.component.css']
})
export class AddItemEduComponent implements OnInit {

  formularioItemEdu:FormGroup
  envio:boolean = false
  formularioEnviado:boolean = false
  previewEnvio:Educacion
  valorImg:any

  constructor(private _builder:FormBuilder, private eduService:EducacionServiceService,
    private router:Router, private storage:StorageService, private tokenService:TokenService) { 

    this.formularioItemEdu = this._builder.group({
      titulo_des: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
      imagen: ['', Validators.required],
      vinculo_img: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
      sobre_educacion: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]]
    })
  }

  ngOnInit(): void {
  }

  datosImg(event:any): void {
    let imagen = event.target.files[0]
    let reader = new FileReader()
    reader.readAsDataURL(imagen)

    reader.onloadend = () => {
      this.valorImg = reader.result
    }
  }

  onSubmit(valor:Educacion):void {
    this.previewEnvio = valor;
    this.previewEnvio.imagen = this.valorImg
    this.formularioEnviado = !this.formularioEnviado;
  }

  resetForm() {
    this.formularioEnviado = !this.formularioEnviado;
    this.formularioItemEdu.reset();
  }

  newPost(formacion:Educacion):void {
    this.eduService.postFormacion(formacion)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    })
    this.goHome()
  }

  enviarform() {
    this.envio = !this.envio
    this.storage.subirImagen(this.valorImg, "formacion_img", "formaciones/")
    .then(img_url => {
      this.previewEnvio.imagen = img_url
      this.newPost(this.previewEnvio)
    })

    
    //this.router.navigate([''])
  }

  goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }
    
}
