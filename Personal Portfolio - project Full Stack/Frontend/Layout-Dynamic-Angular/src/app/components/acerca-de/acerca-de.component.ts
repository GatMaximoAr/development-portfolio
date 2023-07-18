import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { BehaviorSubject, Subscription } from 'rxjs';
import { Acerca } from 'src/app/models/Acerca';
import { AcercaService } from '../../services/Acerca-de/acerca.service';
import { TokenService } from 'src/app/services/Auth/token.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit, OnDestroy {
  //@ViewChild ('AcercaDe') acercade:ElementRef

  sub:Subscription
  subData:Subscription
  getData:boolean = false
  agrega:BehaviorSubject<boolean> = new BehaviorSubject(true)
  isAdmin:boolean = false
  roles:string[] = []

  obj:Acerca = {nombre_usuario:"", 
                apellido_usuario:"", imagen:"", sobre_usuario: "", ocupacion:"", img_portada: ""} 

  constructor(private acercaService:AcercaService,
    private tokenService:TokenService, private storage:StorageService)
     { 
      this.sub = this.storage._Reload.subscribe((resp) => {
        this.getData = resp

        this.getAcerca()

      })
     }

  ngOnInit(): void {
    this.getAcerca()
    //console.log(this.acerca.length)
    this.roles = this.tokenService.getAuthorities()
    this.getRol()
    
  }

  getAcerca():void {
    if (this.getData) {
      this.acercaService.getAcerca().
    subscribe(resp => {
      this.obj = resp
      //console.log(resp)
      this.agrega.next(false)
    }, err =>{
      //this.agrega.next(false)
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

  deleteItem(itemId:number):void {
    this.acercaService.deleteAcerca(itemId)
    .subscribe(resp => {
      //console.log(resp)
      window.location.reload()
    })
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe()
    //this.subData.unsubscribe()
  }

}
