import { Injectable } from '@angular/core';




import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {Usuario} from '../models/usuario';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AcercaDeService {


  private apiServerUrl=environment.apiBaseUrl;


  constructor(private http:HttpClient) { }



  public updateUsuario(usuario: Usuario):Observable<Usuario>{
    return this.http.put<Usuario>(`${this.apiServerUrl}/usuario/update`, usuario);
    

  }

// /*
  public getUsuario():Observable<Usuario>{
    return this.http.get<Usuario>(`${this.apiServerUrl}/usuario/id/1`);

  }

 // */







 
}
