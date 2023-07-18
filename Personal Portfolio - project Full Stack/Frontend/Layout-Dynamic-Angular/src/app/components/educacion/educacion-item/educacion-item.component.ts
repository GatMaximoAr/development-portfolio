import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Educacion } from 'src/app/models/Educacion';
import { TokenService } from 'src/app/services/Auth/token.service';

@Component({
  selector: 'app-educacion-item',
  templateUrl: './educacion-item.component.html',
  styleUrls: ['./educacion-item.component.css']
})
export class EducacionItemComponent implements OnInit {

  mostrar:boolean = true;

  @Input('data') item:Educacion
  @Output() deleteEmit = new EventEmitter<number>()

  isAdmin:boolean = false;
  roles:string[] = []

  constructor(private tokenService:TokenService) { }

  ngOnInit(): void {
    //console.log(this.item)
    this.roles = this.tokenService.getAuthorities()
    this.getRol()
  }

  getRol():void {
    this.roles.forEach(rol => {
      if(rol === "ROLE_ADMIN") {
        this.isAdmin = true
      }
    })
  }

  deleteItem():void {
    this.deleteEmit.emit(this.item.id)
  }

}
