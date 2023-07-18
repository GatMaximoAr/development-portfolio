import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenService } from 'src/app/services/Auth/token.service';
import { ExperienciaService } from 'src/app/services/Experiencia/experiencia.service';
import { StorageService } from 'src/app/services/storage.service';
import { Item_exp } from '../../../../models/Item';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {
  item:Item_exp = {
    img_experiencia : "",
    img_href : "",
    actividad : [],
    sobre_experiencia: ""
  }
  indice:number
  
  formularioItemXp:FormGroup;
  
  valorImg:any
  previewEnvio:Item_exp
  envio:boolean = false
  formularioEnviado:boolean = false
  

  constructor(private dataService:ExperienciaService,
    private route:ActivatedRoute,
    private _builder:FormBuilder,
    private router:Router, private storage:StorageService,
    private tokenService:TokenService) { 

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
    this.indice = this.route.snapshot.params['id']
    this.getItems()
    
  }

  getItems() {
    this.dataService.getItems()
    .subscribe(resp => {
      let respaldo:Item_exp[] = resp
      respaldo.find(call => {
        if(call.id == this.indice) {
          this.item = call;
        }
      })
    })
    
  }


  get form(){
    return this.formularioItemXp.controls
  }

  get actividad(){
    return this.formularioItemXp.get('actividad') as FormArray;
  }

  onSubmit(valor:Item_exp){
   // valor.img_experiencia = this.valorImg
    this.previewEnvio = valor
    this.previewEnvio.img_experiencia = this.valorImg
    this.previewEnvio.id = this.indice
    this.formularioEnviado = !this.formularioEnviado
  } 

  datosImg(event:any): void {
    let imagen = event.target.files[0]
    let reader = new FileReader()
    reader.readAsDataURL(imagen)

    reader.onloadend = () => {
      this.valorImg = reader.result
    }
  }

  putItem(datos:Item_exp){
    this.dataService.editItem(datos)
    .subscribe(data => {
      //console.log(data)
      window.location.reload();
    })
    this.goHome()
  }

  addItemlist(){
   /*  (<FormArray>this.formularioItemXp.get('list')).push(new FormControl(null)); */
   this.actividad.push(new FormControl(null));
  }

  deleteItemList(index:number){
    this.actividad.removeAt(index);
    //console.log(index)
  }

  goHome() {
    this.router.navigate([`/portfolio/${this.tokenService.getUserName()}`]);
  }

  enviarform(){
    this.envio = !this.envio
    this.storage.subirImagen(this.valorImg, "exp_img", "experiencias/").then(resp => {
      this.previewEnvio.img_experiencia = resp
      this.putItem(this.previewEnvio)
    })

    //this.putItem(this.item)
    //this.router.navigate([''])
    //console.log(this.item)
  }

  deleteItem() {
    this.dataService.deleteItem(this.item.id).subscribe(resp => {
      console.log(resp)
      window.location.reload();
    })
  this.goHome()
  }

  resetForm() {
    this.formularioEnviado = !this.formularioEnviado
    this.formularioItemXp.reset()

  }
}
