package com.example.mypetaplication.pojo;

public class Mascota {

    private String nombreMascota;
    private int fotoMascota;
    private int likeMascota;

    public Mascota(String nombreMascota, int fotoMascota, int likeMascota){
        this.nombreMascota = nombreMascota;
        this.fotoMascota = fotoMascota;
        this.likeMascota = likeMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getLikeMascota() {
        return likeMascota;
    }

    public void setLikeMascota(int likeMascota) {
        this.likeMascota = likeMascota;
    }
}
