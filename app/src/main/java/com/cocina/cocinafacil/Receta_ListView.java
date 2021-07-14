package com.cocina.cocinafacil;

public class Receta_ListView {

    private String nombre;
    private int DrawableImageID;

    public Receta_ListView(String nombre, int drawableImageID) {
        this.nombre = nombre;
        DrawableImageID = drawableImageID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDrawableImageID() {
        return DrawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        DrawableImageID = drawableImageID;
    }
}
