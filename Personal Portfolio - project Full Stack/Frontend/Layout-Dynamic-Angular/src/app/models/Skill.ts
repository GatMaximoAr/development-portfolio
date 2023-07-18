export class Skill {
    titulo:string
    porcentaje:number
    color:string

    constructor(titulo:string, porcentaje:number, color:string) {
        this.titulo = titulo
        this.porcentaje = porcentaje
        this.color = color
    }
}

export interface SkillInter {
    id?:number
    titulo:string
    porcentaje:number
    color:string
}