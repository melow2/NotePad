package com.khs.noteexample.model

import android.os.Parcel
import android.os.Parcelable

data class NoteModel(
    var id: Int? = null,
    var title: String? = null,
    var content: String? = null,
    var createTime:String?=null,
    var updateTime:String?=null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {}

    // 아이디가 없을 경우
    constructor(title: String, content: String,createTime: String,updateTime: String) : this() {
        this.title = title
        this.content = content
        this.createTime = createTime
        this.updateTime = updateTime
    }

    // 아이디가 있을 경우
    constructor(id:Int,title:String,content:String,updateTime:String):this(){
        this.id = id
        this.title = title
        this.content = content
        this.updateTime = updateTime
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(createTime)
        parcel.writeString(updateTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoteModel> {
        override fun createFromParcel(parcel: Parcel): NoteModel {
            return NoteModel(parcel)
        }

        override fun newArray(size: Int): Array<NoteModel?> {
            return arrayOfNulls(size)
        }
    }

}
