package com.example.mybooklist.model

import android.os.Parcel
import android.os.Parcelable

data class Movies (var title : String?,
                   var year : String?,
                   var medium_cover_image : String?,
                   var id : Int,var title_english:String?,
                   var title_long : String?,
                   var rating : Float,
                   var summary : String?,
                   var description_full : String?,
                   var synopsis : String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(year)
        parcel.writeString(medium_cover_image)
        parcel.writeInt(id)
        parcel.writeString(title_english)
        parcel.writeString(title_long)
        parcel.writeFloat(rating)
        parcel.writeString(summary)
        parcel.writeString(description_full)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movies> {
        override fun createFromParcel(parcel: Parcel): Movies {
            return Movies(parcel)
        }

        override fun newArray(size: Int): Array<Movies?> {
            return arrayOfNulls(size)
        }
    }
}