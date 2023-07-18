import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { JwtDto } from 'src/app/models/JwtDto';
import { Login } from 'src/app/models/LoginUsuario';
import { NuevoUsuario } from 'src/app/models/NuevoUsuario';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private auth_url:string = "https://portfolio-ap-backend-k8b1.onrender.com/auth/"
  private exist_url:string = "https://portfolio-ap-backend-k8b1.onrender.com/auth/usuario/exist"
  

  private guest:BehaviorSubject<boolean> = new BehaviorSubject(false)
  
  constructor(private http:HttpClient) { }

  get _Access() {
    return this.guest.asObservable()
  }

   _Access_Value(value:boolean) {
    this.guest.next(value)
  }

  public existUser(usuario:string):Observable<boolean> {
    const url_usuario = `${this.exist_url}/${usuario}`
    return this.http.get<boolean>(url_usuario)
  }

  public singUp(nuenoUsuario:NuevoUsuario):Observable<any> {
    return this.http.post(this.auth_url + 'singUp', nuenoUsuario, httpOptions)
  }

  public singIn(loginUsuario:Login):Observable<JwtDto> {
    return this.http.post<JwtDto>(this.auth_url + 'singIn', loginUsuario, httpOptions)
  }
}
