import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Skill, SkillInter } from 'src/app/models/Skill';
import { TokenService } from 'src/app/services/Auth/token.service';
import { SkillService } from 'src/app/services/Skill/skill.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit, OnDestroy {

  items:SkillInter[] = []
  formularioSkill:FormGroup
  envio: boolean = false
  getData:boolean = false
  isAdmin:boolean = false
  agrega:boolean = false
  roles:string[] = []
  sub:Subscription
  subData:Subscription

  constructor(private skillService:SkillService, private _builder:FormBuilder,
    private tokenService:TokenService, private storage:StorageService) { 

      this.sub = this.storage._Reload.subscribe((resp) => {
        this.getData = resp
        
        this.getSkills()
      })

      this.formularioSkill = this._builder.group({
        "titulo":['', [Validators.required, Validators.pattern(/^(\s+\S+\s*)*(?!\s).*$/)]],
        "color":['', [Validators.required]],
        "porcentaje":['', [Validators.required]]
      })
  }

  ngOnInit(): void {
    this.getSkills()
    this.roles = this.tokenService.getAuthorities()
    this.getRol();
  }

  getSkills():void {
    if (this.getData) {
      this.skillService.getSkills()
    .subscribe(resp => {
      //console.log(resp)
      this.items = resp
    })
    }
  }

  getRol():void {
    this.roles.forEach(rol => {
      if(rol === "ROLE_ADMIN") {
        this.isAdmin = true
      }
    })
  }

  post(skill:Skill) {
    this.skillService.postSkill(skill)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    },err => {
      //console.log(err)
    })
  }

  onSubmit(valor:Skill):void {
    //console.log(valor)
    this.envio = !this.envio
    this.post(valor)
  }

  switchValue():void {
    this.agrega = !this.agrega
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe()
    //this.subData.unsubscribe()
  }

}
