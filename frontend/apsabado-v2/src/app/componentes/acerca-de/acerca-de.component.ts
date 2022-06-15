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

  public usuario: Usuario | undefined;

  public editUsuario: Usuario | undefined;
 





  constructor(private acercaDeService: AcercaDeService) { }

  ngOnInit(): void {

    this.getUsuario();


  }




  
 
  public getUsuario():void {
    this.acercaDeService.getUsuario().subscribe({
      next:(Response: Usuario) =>  {
        this.usuario=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
     } )
    
  }

  

  public onOpenModal(mode: string, usuario?: Usuario):void {

    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.type = 'button';
    button.style.display='none';
    button.setAttribute('data-toogle', 'modal');    
    


    if (mode==='edit')  {
      this.editUsuario=usuario;
      button.setAttribute('data-target','#editUsuarioModal');

    }

    

    container?.appendChild(button);
    button.click();


    }

   


      public onUpdateUsuario(usuario: Usuario): void {
      this.editUsuario=usuario;
       
       this.acercaDeService.updateUsuario(usuario).subscribe({
       next: (response:Usuario) => {
         console.log(response);
         this.getUsuario();

         
               },
               error:(error:HttpErrorResponse)=>{
                alert(error.message);
               
              },
           });

          }
       }


   





