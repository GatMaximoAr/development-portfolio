import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skill, SkillInter } from 'src/app/models/Skill';
import { TokenService } from '../Auth/token.service';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class SkillService {

  private url_post:string ="https://portfolio-ap-backend-k8b1.onrender.com/skill/usuario"
  private get_url:string ="https://portfolio-ap-backend-k8b1.onrender.com/skills/traer"
  private url_getBy:string ="https://portfolio-ap-backend-k8b1.onrender.com/skills"
  private put_url:string ="https://portfolio-ap-backend-k8b1.onrender.com/skill/"
  private delete_url:string="https://portfolio-ap-backend-k8b1.onrender.com/skill/"

  constructor(private http:HttpClient, private tokenService:TokenService) { }

  get user():string {
    return this.tokenService.getUserName()
  }

  public getSkills():Observable<SkillInter[]> {
    const url_get = `${this.url_getBy}/${this.user}/traer`
    return this.http.get<SkillInter[]>(url_get)
  }

  public postSkill(skill:Skill):Observable<string> {
    const post_url = `${this.url_post}/${this.user}/crear`
    return this.http.post<string>(post_url, skill, httpOptions)
  }

  public putSkill(skill:SkillInter):Observable<string> {
    const edit_url = `${this.put_url}${skill.id}/editar`
    return this.http.put<string>(edit_url, skill, httpOptions)
  }

  public deleteSkill(id:number):Observable<string> {
    const delete_url =`${this.delete_url}${id}/delete`
    return this.http.delete<string>(delete_url)
  }
}
