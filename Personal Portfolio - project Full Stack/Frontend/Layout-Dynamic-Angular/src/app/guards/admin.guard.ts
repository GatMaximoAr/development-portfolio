import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from '../services/Auth/token.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  realRol:string = 'user'

  constructor(private tokenService:TokenService, 
    private route:Router) {}
    

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      const expectedRol = route.data['expectedRol']
      const roles = this.tokenService.getAuthorities()
      this.realRol = "user"
      //console.log(this.realRol)

      roles.forEach(rol => {
        if(rol === "ROLE_ADMIN") {
          this.realRol = "admin"
        }
      });

      if(!this.tokenService.getToken() || expectedRol.indexOf(this.realRol)=== -1) {
        this.route.navigate(['/'])
        return false
      }
      return true
  }
  
}
