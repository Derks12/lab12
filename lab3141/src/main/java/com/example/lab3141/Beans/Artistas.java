package com.example.lab3141.Beans;

import java.util.Date;

public class Artistas {

    private int idArtistas;
    private String Nombre_Grupo;
    private Date Fecha_Creacion;
    private String Tipo_musica;

    public int getIdArtistas() {
        return idArtistas;
    }

    public void setIdArtistas(int idArtistas) {
        this.idArtistas = idArtistas;
    }

    public String getNombre_Grupo() {
        return Nombre_Grupo;
    }

    public void setNombre_Grupo(String nombre_Grupo) {
        Nombre_Grupo = nombre_Grupo;
    }

    public Date getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        Fecha_Creacion = fecha_Creacion;
    }

    public String getTipo_musica() {
        return Tipo_musica;
    }

    public void setTipo_musica(String tipo_musica) {
        Tipo_musica = tipo_musica;
    }
}
