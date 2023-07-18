import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/models/Educacion';
import { TokenService } from 'src/app/services/Auth/token.service';
import { EducacionServiceService } from 'src/app/services/Educacion/educacion-service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-update-item-edu',
  templateUrl: './update-item-edu.component.html',
  styleUrls: ['./update-item-edu.component.css']
})
export class UpdateItemEduComponent implements OnInit {

  indice:number
  item:Educacion = {
    titulo_des:"",
    imagen:"",
    vinculo_img:"",
    sobre_educacion:""
  }

  formularioItemEdu:FormGroup
  envio:boolean = false
  formularioEnviado:boolean = false
  previewEnvio:Educacion
  valorImg:any



  constructor(private _builder:FormBuilder, private eduService:EducacionServiceService,
    private router:Router, private route:ActivatedRoute, private storage:StorageService,
    private tokenService:TokenService) { 

    this.formularioItemEdu = this._builder.group({
      titulo_des: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
      imagen: ['', Validators.required],
      vinculo_img: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
      sobre_educacion: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]]
    })
  }

  ngOnInit(): void {
    this.indice = this.route.snapshot.params['id']
    this.getItem();
  }

  datosImg(event:any): void {
    let imagen = event.target.files[0]
    let reader = new FileReader()
    reader.readAsDataURL(imagen)

    reader.onloadend = () => {
      this.valorImg = reader.result
    }
  }

  getItem():void {
    this.eduService.getById(this.indice)
    .subscribe(resp => {
      this.item = resp
    })
  }

  putItem(formacion:Educacion):void {
    this.eduService.putFormacion(formacion)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    })
    this.goHome()
  }

    enviarform() {
      this.envio = !this.envio
      this.storage.subirImagen(this.valorImg, "formacion_img", "formaciones/")
      .then(url_img => {
        this.previewEnvio.imagen = url_img
        
        this.putItem(this.previewEnvio);
      })

      //this.router.navigate([''])
    }
    resetForm() {
      this.formularioEnviado = !this.formularioEnviado;
      this.formularioItemEdu.reset();
    }
    onSubmit(valor:Educacion) {
      this.previewEnvio = valor;
      this.previewEnvio.imagen = this.valorImg
      this.previewEnvio.id = this.indice
      this.formularioEnviado = !this.formularioEnviado;
      //console.log(this.previewEnvio)
    }

    deleteItem() {
      this.eduService.deleteFormacion(this.indice)
      .subscribe(resp => {
        //console.log(resp)
        window.location.reload()
      })
      
      this.goHome()
    }

    goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }

}
