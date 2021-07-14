package com.cocina.cocinafacil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

class BajarImagen {
    private static Bitmap cargarImagen;
    private static String httpImagenAdress;

    public static Bitmap CargaImagen(String direccion)
    {
        URL imagenNueva = null;
        try {
            imagenNueva = new URL(direccion);
            HttpURLConnection conn = (HttpURLConnection) imagenNueva.openConnection();
            conn.connect();
            cargarImagen = BitmapFactory.decodeStream(conn.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cargarImagen;
    }
}
