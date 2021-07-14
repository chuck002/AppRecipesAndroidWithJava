package com.cocina.cocinafacil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RecetasAdapter extends ArrayAdapter {

    private ArrayList<Receta_ListView> datos;
    private Context context;

    public RecetasAdapter(Context context, ArrayList datos) {
        super(context, R.layout.recetas_list_view, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.recetas_list_view, null);

        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.
        // Recogemos el ImageView y le asignamos una foto.
        ImageView imagen = (ImageView) item.findViewById(R.id.imageView);
        imagen.setImageResource(datos.get(position).getDrawableImageID());

        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView nombre = (TextView) item.findViewById(R.id.txt_receta);
        nombre.setText(datos.get(position).getNombre());

        // Recogemos el TextView para mostrar el número de celda y lo
        // establecemos.
        //TextView numCelda = (TextView) item.findViewById(R.id.tvField);
        //numCelda.setText(String.valueOf(position));

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }
}
