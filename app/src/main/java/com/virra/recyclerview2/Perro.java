package com.virra.recyclerview2;

public class Perro {

    String  nombre;
    int foto;
    String megusta;

    public String getMegusta() {
        return megusta;
    }

    public void setMegusta(String megusta) {
        this.megusta = megusta;
    }



    public Perro(int foto, String nombre,String  gusta) {
        this.foto = foto;
        this.nombre = nombre;
        this.megusta=gusta;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
