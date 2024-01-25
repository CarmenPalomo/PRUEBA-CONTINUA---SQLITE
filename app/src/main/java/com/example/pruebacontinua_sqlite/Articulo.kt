package com.example.pruebacontinua_sqlite

import android.os.Parcel
import android.os.Parcelable

class Articulo(
    private var tipoArticulo: String?,
    private var nombre: String?,
    private var peso: String?,
    private var precio: String?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    fun getPeso(): String? {
        return peso
    }
    fun getPrecio(): String? {
        return precio
    }
    enum class TipoArticulo(val tipo :String){
        ARMA("arma"),
        OBJETO("objeto"),
        PROTECCION("proteccion")


    }

    enum class Nombre(val tipo :String){
        BASTON("baston"),
        ESPADA("espada"),
        DAGA("daga"),
        MARTILLO("martillo"),
        GARRAS("garras"),
        POCION("pocion"),
        IRA("ira"),
        ESCUDO("escudo"),
        ARMADURA("armadura")
    }

    fun enumArt(): TipoArticulo{
        when(tipoArticulo){
            TipoArticulo.PROTECCION.toString() ->{
                return TipoArticulo.PROTECCION
            }
            TipoArticulo.OBJETO.toString() ->{
                return TipoArticulo.OBJETO
            }
            else-> return TipoArticulo.ARMA
        }
    }

    fun enumNombre():Nombre{
        when(nombre){
            Nombre.BASTON.toString()-> return Nombre.BASTON
            Nombre.ESPADA.toString() -> return Nombre.ESPADA
            Nombre.DAGA.toString() -> return Nombre.DAGA
            Nombre.MARTILLO.toString() -> return Nombre.MARTILLO
            Nombre.GARRAS.toString() -> return Nombre.GARRAS
            Nombre.IRA.toString() -> return Nombre.IRA
            Nombre.ESCUDO.toString() -> return Nombre.ESCUDO
            else -> return return Nombre.ARMADURA
        }
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Articulo> {
        override fun createFromParcel(parcel: Parcel): Articulo {
            return Articulo(parcel)
        }

        override fun newArray(size: Int): Array<Articulo?> {
            return arrayOfNulls(size)
        }
    }

}