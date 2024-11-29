package com.example.aplicaciongestionlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class sqlBDD extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "elementos.db";
    private static final int DATABASE_VERSION = 1;

    // Tabla y columnas
    private static final String TABLE_ELEMENTOS = "elementos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITULO = "titulo";
    private static final String COLUMN_DESCRIPCION = "descripcion";
    private static final String COLUMN_PUNTUACION = "puntuacion";
    private static final String COLUMN_FECHA_ENTREGA = "fecha_entrega";

    public sqlBDD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de elementos
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ELEMENTOS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITULO + " TEXT, "
                + COLUMN_DESCRIPCION + " TEXT, "
                + COLUMN_PUNTUACION + " REAL, "
                + COLUMN_FECHA_ENTREGA + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENTOS);
        onCreate(db);
    }

    // Insertar un nuevo elemento
    public long addElemento(Elemento elemento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, elemento.getTitulo());
        values.put(COLUMN_DESCRIPCION, elemento.getDescripcion());
        values.put(COLUMN_PUNTUACION, elemento.getPuntuacion());
        values.put(COLUMN_FECHA_ENTREGA, elemento.getFechaEntrega());
        long id = db.insert(TABLE_ELEMENTOS, null, values);
        db.close();
        return id;
    }

    // Obtener todos los elementos
    public List<Elemento> getAllElementos() {
        List<Elemento> elementos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ELEMENTOS, null);

        if (cursor.moveToFirst()) {
            do {
                Elemento elemento = new Elemento(
                        R.drawable.android, // Placeholder para la imagen
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITULO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPCION)),
                        cursor.getFloat(cursor.getColumnIndexOrThrow(COLUMN_PUNTUACION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA_ENTREGA))
                );
                elementos.add(elemento);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return elementos;
    }

    // Eliminar un elemento por ID
    public void deleteElemento(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ELEMENTOS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
}