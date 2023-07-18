import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Proyecto } from 'src/app/models/Proyecto';
import { TokenService } from 'src/app/services/Auth/token.service';
import { ProyectoServiceService } from 'src/app/services/Proyecto/proyecto-service.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit, OnDestroy {

  proyectos:Proyecto[] = []
  getData:boolean = false
  isAdmin: boolean = false
  roles:string[]
  user:string 
  sub:Subscription
  subData:Subscription

  constructor(private proyectoService:ProyectoServiceService, private tokenService:TokenService,
    private storage:StorageService) {

      this.sub = this.storage._Reload.subscribe((resp) =>{
        this.getData = resp
        this.getProyectos()
      })
    }
  

  ngOnInit(): void {
    this.getProyectos();
    this.roles = this.tokenService.getAuthorities()
    this.getRoles()
    }

   getProyectos():void {
    
    if (this.getData) {
      this.proyectoService.getProyectos()
    .subscribe(resp => {
      this.proyectos = resp;
      //console.log(resp);
    })
    }
   }

    getRoles():void {
      this.roles.forEach(rol => {
        if(rol === "ROLE_ADMIN") {
          this.isAdmin = true
        }
      })
    }

    deleteItem(itemId:number) {
      //console.log(itemId)
      this.proyectoService.deleteProyecto(itemId)
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
