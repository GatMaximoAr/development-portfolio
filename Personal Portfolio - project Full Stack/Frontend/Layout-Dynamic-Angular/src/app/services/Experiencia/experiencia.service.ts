import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item_exp } from 'src/app/models/Item'; 
import { User } from 'src/app/models/User'
import { TokenService } from '../Auth/token.service';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  private url ="https://portfolio-ap-backend-k8b1.onrender.com/relacionxp/traer/"
  private url_get="https://portfolio-ap-backend-k8b1.onrender.com/relacionxp"
  private url_post ="https://portfolio-ap-backend-k8b1.onrender.com/relacioxp/usuario"
  private url_edit = "https://portfolio-ap-backend-k8b1.onrender.com/relacioxp/editar"
  private url_delete = "https://portfolio-ap-backend-k8b1.onrender.com/experiencia/delete"

  constructor(private http:HttpClient, private tokenService:TokenService) { }

  get user():string {
    return this.tokenService.getUserName()
  }

  getItems():Observable<Item_exp[]> {
    const url_get = `${this.url_get}/${this.user}/traer`
    return this.http.get<Item_exp[]>(url_get)
  }

  postItem(newValorItem:Item_exp):Observable<Item_exp>{
    const post_url = `${this.url_post}/${this.user}`
    return this.http.post<Item_exp>(post_url, newValorItem ,httpOptions)
  }

  editItem(itemtoEdit:Item_exp):Observable<Item_exp> {
    const editUrl = `${this.url_edit}/${itemtoEdit.id}`
    return this.http.put<Item_exp>(editUrl, itemtoEdit,httpOptions)
  }

  deleteItem(id:number):Observable<Item_exp> {
    const itemUrl = `${this.url_delete}/${id}`
    return this.http.delete<Item_exp>(itemUrl, httpOptions)
  } 
}
