export interface JwtDto {
    token:string;
    type:string;
    nombreUsuario:string;
    authorities:string[];
}