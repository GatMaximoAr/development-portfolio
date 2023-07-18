import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Item_exp } from 'src/app/models/Item'; 
import { AuthService } from 'src/app/services/Auth/auth.service';
import { Subscription } from 'rxjs';
import { TokenService } from 'src/app/services/Auth/token.service';

@Component({
  selector: 'app-experiencia-item',
  templateUrl: './experiencia-item.component.html',
  styleUrls: ['./experiencia-item.component.css']
})
export class ExperienciaItemComponent implements OnInit, OnDestroy {

  @Input('data') item:Item_exp
  @Output() deleteEmit = new EventEmitter<number>()

  isAdmin:boolean
  sub:Subscription
  roles:string[] = []


  constructor(private tokenService:TokenService) { 
  }

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

  ngOnDestroy(): void {
  }

}
