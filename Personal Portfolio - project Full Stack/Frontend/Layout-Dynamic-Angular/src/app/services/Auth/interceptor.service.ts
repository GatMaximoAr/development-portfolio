import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, finalize } from 'rxjs';
import { SpinnerService } from '../spinner.service';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor(private tokenService:TokenService, private spinnerService:SpinnerService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.spinnerService.show()

    let intReq = req
    const token = this.tokenService.getToken()

    if(token != null) {
      intReq = req.clone({
        headers: req.headers.set('Authorization', 'Bearer' + token)
      })
    }
    //console.log(intReq)
    return next.handle(intReq).pipe(
      finalize(() => this.spinnerService.hide())
    )
  }
}

export const interceptorProvider = [{provide: HTTP_INTERCEPTORS, useClass:InterceptorService, multi: true}];
