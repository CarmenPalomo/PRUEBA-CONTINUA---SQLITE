package com.example.pruebacontinua_sqlite

import android.os.Parcel
import android.os.Parcelable

class Personaje(
    private var nombre: String?,
    private val raza: String?,
    private val clase: String?,
    private var estadoVital:String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(raza)
        parcel.writeString(clase)
        parcel.writeString(estadoVital)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Personaje> {
        override fun createFromParcel(parcel: Parcel): Personaje {
            return Personaje(parcel)
        }

        override fun newArray(size: Int): Array<Personaje?> {
            return arrayOfNulls(size)
        }
    }
}