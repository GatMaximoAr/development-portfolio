import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/models/Proyecto';
import { TokenService } from 'src/app/services/Auth/token.service';
import { ProyectoServiceService } from 'src/app/services/Proyecto/proyecto-service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-proyecto-update',
  templateUrl: './proyecto-update.component.html',
  styleUrls: ['./proyecto-update.component.css']
})
export class ProyectoUpdateComponent implements OnInit {


  formularioItemPro:FormGroup
  envio:boolean = false
  formularioEnviado:boolean = false
  item:Proyecto ={
    titulo:"",
    imagen:"",
    vinculo_img:"",
    sobre_proyecto:""
  }
  indice:number
  previewEnvio:Proyecto
  valorImg:any

  constructor(private _builder:FormBuilder, private proyectoService:ProyectoServiceService,
    private router:Router, private route:ActivatedRoute, private storage:StorageService,
    private tokenService:TokenService) { 

      this.formularioItemPro = this._builder.group({
        titulo: ['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
        imagen: ['', Validators.required],
        vinculo_img: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
        sobre_proyecto: ['',[Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]]
      })
    }

  ngOnInit(): void {
    this.indice = this.route.snapshot.params['id']
    this.getItem()
  }

  getItem(): void {
    this.proyectoService.getById(this.indice)
    .subscribe(resp => {
      this.item = resp
    })
  }

  datosImg(event:any): void {
    let imagen = event.target.files[0]
    let reader = new FileReader()
    reader.readAsDataURL(imagen)

    reader.onloadend = () => {
      this.valorImg = reader.result
    }
  }

  onSubmit(valor:Proyecto):void {
    this.previewEnvio = valor;
    this.previewEnvio.id = this.indice
    this.previewEnvio.imagen = this.valorImg
    this.formularioEnviado = !this.formularioEnviado;
  }

  resetForm() {
    this.formularioEnviado = !this.formularioEnviado;
    this.formularioItemPro.reset();
  }

   putItem(proyecto:Proyecto):void {
    this.proyectoService.putProyecto(proyecto)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    })
    this.goHome()
  }
  
  deleteItem() {
    this.proyectoService.deleteProyecto(this.indice)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    })
    this.goHome()
    }

  enviarform() {
    this.envio = !this.envio
    this.storage.subirImagen(this.valorImg, "proyecto_img", "proyectos/")
    .then(img_url => {
      this.previewEnvio.imagen = img_url
      this.putItem(this.previewEnvio)
      
    })

    //this.router.navigate([''])
    //console.log(this.previewEnvio)
  }

  goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }

}
