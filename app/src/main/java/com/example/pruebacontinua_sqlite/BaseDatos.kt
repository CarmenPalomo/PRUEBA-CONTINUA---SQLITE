package com.example.pruebacontinua_sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context): SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "Mochila.db"
        private const val TABLA_MOCHILA = "Mochila"
        private const val KEY_ID = "id"
        private const val TIPO_ARTICULO = "tipoArticulo"
        private const val NOMBRE = "nombre"
        private const val PESO = "peso"
        private const val PRECIO = "precio"
    }

    override fun onCreate(db: SQLiteDatabase?) {
       val createTable = "CREATE TABLE $TABLA_MOCHILA ($KEY_ID INTEGER PRIMARY KEY, "+
               "$TIPO_ARTICULO TEXT, $NOMBRE TEXT, $PESO INTEGER, $PRECIO INTEGER )"

        if (db != null) {
            db.execSQL(createTable)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $TABLA_MOCHILA")
            onCreate(db)
        }

    }

    fun getNumeroArticulos(): Int{
       var numero: Int = 0
        val query = "SELECT * FROM $TABLA_MOCHILA"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()){
            do {
                numero += 1
            }while (cursor.moveToNext())
        }

        return numero
    }

    fun añadirArticulo(articulo: Articulo){
        val db = this.writableDatabase
        val values = ContentValues().apply{
            put(TIPO_ARTICULO, articulo.enumArt().name)
            put(NOMBRE, articulo.enumNombre().name)
            put(PESO, articulo.getPeso())
            put(PRECIO, articulo.getPrecio())
        }

        db.insert(TABLA_MOCHILA, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getContenido(): ArrayList<Articulo>{
        val articulo = ArrayList<Articulo>()
        val query = "SELECT * FROM $TABLA_MOCHILA"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()){
            do{
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val tipoArticulo = cursor.getString(cursor.getColumnIndex(TIPO_ARTICULO))
                val nombre = cursor.getString(cursor.getColumnIndex(NOMBRE))
                val peso = cursor.getString(cursor.getColumnIndex(PESO))
                val precio = cursor.getString(cursor.getColumnIndex(PRECIO))
               articulo.add(Articulo(tipoArticulo,nombre,peso,precio))

            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return articulo
    }

    @SuppressLint("Range")
    fun findObjeto(articulo: Articulo): Articulo{
        val query = "SELECT * FROM $TABLA_MOCHILA WHERE articulo = $NOMBRE"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()){
            val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
            val TipoArticulo = articulo.enumArt()
            val nombre = articulo.enumNombre()
            val peso = articulo.getPeso()
            val precio = articulo.getPrecio()

        }
        var articulo = Articulo(TIPO_ARTICULO, NOMBRE, PESO, PRECIO )

        return articulo
    }




}




// tipo articulo String, nombre string, peso int, precio int