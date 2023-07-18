import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Skill, SkillInter } from 'src/app/models/Skill';
import { TokenService } from 'src/app/services/Auth/token.service';
import { SkillService } from 'src/app/services/Skill/skill.service';

@Component({
  selector: 'app-skill-item',
  templateUrl: './skill-item.component.html',
  styleUrls: ['./skill-item.component.css']
})
export class SkillItemComponent implements OnInit {

  @Input('data') item:SkillInter

  cssBoostrap:string ="progress-bar "
  isAdmin: boolean = false
  formularioSkill:FormGroup
  skillPut:SkillInter = {
    titulo:"",
    color:"",
    porcentaje:0
  }
  enEdicion:boolean
  roles:string[] = []

  constructor(private _builder:FormBuilder, private skillService:SkillService,
    private tokenService:TokenService) { 
    this.formularioSkill = this._builder.group({
      "titulo":['', [Validators.required]],
      "color":['', [Validators.required]],
      "porcentaje":['', [Validators.required]]
    })
  }

  ngOnInit() {
    this.bindingVar()
    //console.log(this.item)
    //console.log(this.cssBoostrap)
    this.roles = this.tokenService.getAuthorities()
    this.getRol()
    //console.log(this.isAdmin)

  }

  getRol():void {
    this.roles.forEach(rol => {
      if(rol === "ROLE_ADMIN") {
        this.isAdmin = true
      }
    })
  }

  bindingVar():void {
    this.cssBoostrap = this.cssBoostrap + this.item.color
    //this.cssStyle = `${this.cssStyle} ${this.item.porcentaje}%;`
  }

  onSubmit(valor:Skill):void {
    console.log(valor)
    this.skillPut.id = this.item.id
    this.skillPut.titulo = valor.titulo
    this.skillPut.color = valor.color
    this.skillPut.porcentaje = valor.porcentaje
    this.put(this.skillPut)
    
  }

  put(skill:SkillInter):void {
    this.skillService.putSkill(skill)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload();
    },err => {
      //console.log(err)
    })
  }

  deleteSkill(id:number):void {
    this.skillService.deleteSkill(id)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    },err => {
      //console.log(err)
    })
  }

  delete():void {
    this.deleteSkill(this.item.id)
  }

  switchValue():void {
    this.enEdicion = !this.enEdicion
  }

}
