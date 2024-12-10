package com.example.aplicaciongestionlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class sqlBDD extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "elementos4.db";
    private static final int DATABASE_VERSION = 4;

    // Tabla y columnas
    private static final String TABLE_ELEMENTOS = "elementos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITULO = "titulo";
    private static final String COLUMN_DESCRIPCION = "descripcion";
    private static final String COLUMN_PUNTUACION = "puntuacion";
    private static final String COLUMN_FECHA_ENTREGA = "fecha_entrega";

    private static final String TABLE_USUARIOS = "usuarios";
    private static final String COLUMN_ID_USUARIO = "id_usuario";
    private static final String COLUMN_NOMBRE_USUARIO = "nombre_usuario";
    private static final String COLUMN_CONTRASENA = "contrasena";

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
                + COLUMN_FECHA_ENTREGA + " TEXT, "
                + COLUMN_ID_USUARIO + " INTEGER)";
        db.execSQL(CREATE_TABLE);
        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_USUARIOS + "("
                + COLUMN_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOMBRE_USUARIO + " TEXT, "
                + COLUMN_CONTRASENA + " TEXT) ";

        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENTOS);
        onCreate(db);
    }

    // Insertar un nuevo elemento
    public long addElemento(Elemento elemento,int id_usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITULO, elemento.getTitulo());
        values.put(COLUMN_DESCRIPCION, elemento.getDescripcion());
        values.put(COLUMN_PUNTUACION, elemento.getPuntuacion());
        values.put(COLUMN_FECHA_ENTREGA, elemento.getFechaEntrega());
        values.put(COLUMN_ID_USUARIO,id_usuario);
        long id = db.insert(TABLE_ELEMENTOS, null, values);
        db.close();
        return id;
    }

    // Obtener todos los elementos
    public List<Elemento> getAllElementos(int idUsuario) {
        List<Elemento> elementos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_ELEMENTOS + " WHERE id_usuario = ?",
                new String[]{String.valueOf(idUsuario)} // Pasamos el parámetro de forma segura
        );

        if (cursor.moveToFirst()) {
            do {
                Elemento elemento = new Elemento(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
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
    // Obtener el último ID de la tabla
    public int getLastIdElemento() {
        int lastId = -1; // Valor por defecto si no se encuentra ningún registro
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            // Consulta para obtener el máximo ID
            String query = "SELECT MAX(" + COLUMN_ID + ") AS lastId FROM " + TABLE_ELEMENTOS;
            cursor = db.rawQuery(query, null);

            if (cursor != null && cursor.moveToFirst()) {
                lastId = cursor.getInt(cursor.getColumnIndexOrThrow("lastId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return lastId;
    }

    public long addUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE_USUARIO, usuario.getNombre());
        values.put(COLUMN_CONTRASENA, usuario.getContraseña());
        long id = db.insert(TABLE_USUARIOS, null, values);
        db.close();
        return id;
    }
    public int getLastIdUsuario() {
        int lastId = -1; // Valor por defecto si no se encuentra ningún registro
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            // Consulta para obtener el máximo ID
            String query = "SELECT MAX(" + COLUMN_ID_USUARIO + ") AS lastId FROM " + TABLE_USUARIOS;
            cursor = db.rawQuery(query, null);

            if (cursor != null && cursor.moveToFirst()) {
                lastId = cursor.getInt(cursor.getColumnIndexOrThrow("lastId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return lastId;
    }
    public ArrayList<Usuario> getAllUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USUARIOS, null);

        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID_USUARIO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE_USUARIO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTRASENA))
                );
                usuarios.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return usuarios;
    }

}