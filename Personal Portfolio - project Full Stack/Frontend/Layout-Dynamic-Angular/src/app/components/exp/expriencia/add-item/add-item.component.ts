import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Item_exp } from 'src/app/models/Item'; 
import { TokenService } from 'src/app/services/Auth/token.service';
import { ExperienciaService } from 'src/app/services/Experiencia/experiencia.service'; 
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  formularioItemXp:FormGroup
  valorImg: any;
  formularioEnviado:boolean = false
  envio:boolean = false
  previewEnvio:Item_exp

  constructor(private _builder:FormBuilder,
    private dataService:ExperienciaService, private tokenService:TokenService,
    private router:Router, private storage:StorageService) { 

      this.formularioItemXp = this._builder.group({
        img_experiencia: ['', Validators.required],
        sobre_experiencia: ['', Validators.required],
        img_href: ['', Validators.required],
    
        actividad:this._builder.array([
          this._builder.control('', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)])
          
        ])
    })
    }

  ngOnInit(): void {
  }


  onSubmit(valor:Item_exp){
    //valor.img_experiencia = this.valorImg
    this.previewEnvio = valor
    this.previewEnvio.img_experiencia = this.valorImg
    //console.log(this.previewEnvio)
    this.formularioEnviado = !this.formularioEnviado
    
  }

  get form(){
    return this.formularioItemXp.controls
  }

  get actividad(){
    return this.formularioItemXp.get('actividad') as FormArray;
  }

   datosImg(event:any): void {
    let imagen = event.target.files[0]
    let reader = new FileReader()
    reader.readAsDataURL(imagen)

    reader.onloadend = () => {
      this.valorImg = reader.result
    }
  }
 
  addItemlist(){
    /*  (<FormArray>this.formularioItemXp.get('list')).push(new FormControl(null)); */
    this.actividad.push(new FormControl(null));
   }

   deleteItemList(index:number){
    this.actividad.removeAt(index);
  }

  postItem(parametro:Item_exp) {
    this.dataService.postItem(parametro)
    .subscribe(data => {
      //console.log(data)
      window.location.reload();
    })
   /* this.router.navigate(['/portfolio'])
  .then(() => {
    window.location.reload();
  });*/
  this.goHome()
  }

  enviarform() {
    this.envio = !this.envio
    this.storage.subirImagen(this.valorImg, "exp_img", "experiencias/").then(resp => {
      this.previewEnvio.img_experiencia = resp
      this.postItem(this.previewEnvio)
    })

    //this.postItem(this.previewEnvio)
    //this.router.navigate([''])
  }

  goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }

  resetForm() {
    this.formularioEnviado = !this.formularioEnviado
    this.formularioItemXp.reset()
  }
}
