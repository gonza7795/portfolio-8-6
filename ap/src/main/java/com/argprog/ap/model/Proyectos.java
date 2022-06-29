
package com.argprog.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity


public class Proyectos {
    
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long idProy;
    private String tituloProy;
    private int fechaProy;
    private String descProy;
    private String imagenProy;

    public Proyectos() {
    }

    public Proyectos(Long idProy, String tituloProy, int fechaProy, String descProy, String imagenProy) {
        this.idProy = idProy;
        this.tituloProy = tituloProy;
        this.fechaProy = fechaProy;
        this.descProy = descProy;
        this.imagenProy = imagenProy;
    }

    public Long getIdProy() {
        return idProy;
    }

    public void setIdProy(Long idProy) {
        this.idProy = idProy;
    }

    public String getTituloProy() {
        return tituloProy;
    }

    public void setTituloProy(String tituloProy) {
        this.tituloProy = tituloProy;
    }

    public int getFechaProy() {
        return fechaProy;
    }

    public void setFechaProy(int fechaProy) {
        this.fechaProy = fechaProy;
    }

    public String getDescProy() {
        return descProy;
    }

    public void setDescProy(String descProy) {
        this.descProy = descProy;
    }

    public String getImagenProy() {
        return imagenProy;
    }

    public void setImagenProy(String imagenProy) {
        this.imagenProy = imagenProy;
    }
    
    
    
    
}


