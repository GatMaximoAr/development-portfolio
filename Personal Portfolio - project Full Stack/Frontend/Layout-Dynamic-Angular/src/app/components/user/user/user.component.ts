import { Component, OnInit } from '@angular/core';
import { async } from '@angular/core/testing';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthService } from 'src/app/services/Auth/auth.service';
import { TokenService } from 'src/app/services/Auth/token.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  usuario:string

  constructor(private router:ActivatedRoute, private tokenService:TokenService,
    private auth:AuthService, private route:Router, private storage:StorageService) { 
      this.asignarUsuario()
    }

  ngOnInit(): void {
    this.asignarUsuario()
    
    //console.log(this.usuario)
  }

  async exist(usuario:string) {
    this.auth.existUser(usuario).subscribe(async (resp) => {
      if(resp) {
        this.tokenService.setUserName(this.usuario)
        this.storage._Value_Reload(true)
      }else {
        alert("ese usuario no existe, puedes crearlo...")
        this.route.navigate(['/singUp'])
      }
    })
  }

  async asignarUsuario() {
    this.router.params.subscribe(async (params:Params) => {
      this.usuario = params['usuario']
      this.exist(this.usuario)
    } )
  }
}
