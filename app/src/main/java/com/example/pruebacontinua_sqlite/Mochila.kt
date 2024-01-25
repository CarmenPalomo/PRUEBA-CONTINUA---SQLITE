package com.example.pruebacontinua_sqlite

import android.os.Parcel
import android.os.Parcelable

class Mochila(
    private var contenido: ArrayList<Articulo> = ArrayList<Articulo>()
): Parcelable {
    constructor() : this(TODO("contenido")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mochila> {
        override fun createFromParcel(parcel: Parcel): Mochila {
            return Mochila()
        }

        override fun newArray(size: Int): Array<Mochila?> {
            return arrayOfNulls(size)
        }
    }
}