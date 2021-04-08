package com.example.githubusersurya

import android.os.Parcel
import android.os.Parcelable

data class gitUser(var name:String?, var username:String?, var location:String?, var repository: Int, var company:String?, var followers: Int, var following: Int, var avatar: Int): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(location)
        parcel.writeInt(repository)
        parcel.writeString(company)
        parcel.writeInt(followers)
        parcel.writeInt(following)
        parcel.writeInt(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<gitUser> {
        override fun createFromParcel(parcel: Parcel): gitUser {
            return gitUser(parcel)
        }

        override fun newArray(size: Int): Array<gitUser?> {
            return arrayOfNulls(size)
        }
    }
}