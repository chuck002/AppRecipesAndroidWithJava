package com.cocina.cocinafacil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseManager {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseManager instance;

    public Cursor c = null;

    private DatabaseManager(Context context)
    {
        this.openHelper = new MyDB(context);
    }

    public static DatabaseManager getInstance(Context context)
    {
        if(instance == null){
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }

    public void close()
    {
        if(db != null)
        {
            this.db.close();
        }
    }

    public String getNombre(int id, String tabla)
    {
        c = db.rawQuery("select NOMBRE from "+tabla+" where Id = '"+id+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            String nombre = c.getString(0);
            buffer.append(""+nombre);
        }
        return buffer.toString();
    }

    public String getNombre(int id)
    {
        c = db.rawQuery("select NOMBRE from recetas where Id = '"+id+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            String nombre = c.getString(0);
            buffer.append(""+nombre);
        }
        return buffer.toString();
    }
    public String getIngredientes(int id)
    {
        c = db.rawQuery("select INGREDIENTES from recetas where Id = '"+id+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            String nombre = c.getString(0);
            buffer.append(""+nombre);
        }
        return buffer.toString();
    }

    public String getIngredientes(int id, String tabla)
    {
        c = db.rawQuery("select INGREDIENTES from "+tabla+" where Id = '"+id+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            String nombre = c.getString(0);
            buffer.append(""+nombre);
        }
        return buffer.toString();
    }

    public String getFoto(int id, String tabla)
    {
        c = db.rawQuery("select IMAGEN from "+tabla+" where Id = '"+id+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext())
        {
            String nombre = c.getString(0);
            buffer.append(""+nombre);
        }
        return buffer.toString();
    }
    public int getCantidadRegistros(String tabla)
    {
        c = db.rawQuery("select * from "+tabla+"", new String[]{});
        return c.getCount();
    }
}
