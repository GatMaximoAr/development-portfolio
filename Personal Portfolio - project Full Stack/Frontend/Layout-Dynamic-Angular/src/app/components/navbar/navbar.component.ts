import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/Auth/auth.service';
import { TokenService } from 'src/app/services/Auth/token.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, OnDestroy {

  sub:Subscription
  isLogged:boolean = false

  constructor(private tokenService:TokenService, private route:Router,
    private authService:AuthService) {

      this.sub = this.authService._Access.subscribe(resp => {
      this.isLogged = resp
      })
    }
  

  ngOnInit(): void {
    if(this.tokenService.getToken()) {
      this.isLogged = true
    }else {
      this.isLogged = false
    }

    //console.log(this.isLogged)
    //console.log(this.tokenService.getToken())
    //console.log(this.tokenService.getAuthorities())
  }

  logOut() {
   this.tokenService.logOut()
   window.location.reload()
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe()
  }


}
