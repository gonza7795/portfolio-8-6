import { Component, OnInit } from '@angular/core';


import { HttpErrorResponse } from '@angular/common/http';

import { Usuario } from 'src/app/models/usuario';

import { AcercaDeService } from 'src/app/servicios/acerca-de.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  public usuarios: Usuario | undefined;

  public editUsuario: Usuario | undefined;
  //public deleteEducation: Education | undefined;





  constructor(private acercaDeService: AcercaDeService) { }

  ngOnInit(): void {

    this.getUsuarios();


  }




  
 
  public getUsuarios():void {
    this.acercaDeService.getUsuario().subscribe({
      next:(Response: Usuario) =>  {
        this.usuarios=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
     } )
    
  }

  

  public onOpenModal(mode: string, usuario?: Usuario):void {

    const container=document.getElementById('main-container');

    const button=document.createElement('button');

    button.style.display='none';


    button.setAttribute('data-toogle', 'modal');



   

    if (mode==='edit')  {
      this.editUsuario=usuario;
      button.setAttribute('data-target','#editUsuarioModal');

    }

    container?.appendChild(button);
    button.click();


    }

   


      public onUpdateUsuario(usuario: Usuario)
      {this.editUsuario=usuario;
       document.getElementById('add-usuario-form')?.click();
       this.acercaDeService.updateUsuario(usuario).subscribe({
       next: (response:Usuario) => {
         console.log(response);
         this.getUsuarios();

         
               },
               error:(error:HttpErrorResponse)=>{
                alert(error.message);
               
              }
           })
       }


   




}
