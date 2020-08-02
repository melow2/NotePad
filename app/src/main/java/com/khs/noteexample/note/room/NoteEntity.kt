package com.khs.noteexample.note.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "note_table"
)
data class NoteEntity(
    @ColumnInfo(name="note_title")
    var noteTitle:String?=null,
    @ColumnInfo(name="note_content")
    var noteContent:String?=null,
    @ColumnInfo(name="note_create_time")
    var noteCreateTime:String?=null,
    @ColumnInfo(name="note_update_time")
    var noteUpdateTime:String?=null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="note_id")
    var noteId:Int?=null

    constructor(id:Int,title:String?,content:String?,noteCreateTime: String?,noteUpdateTime: String?):this(){
        this.noteId =id
        this.noteTitle = title
        this.noteContent = content
        this.noteCreateTime =noteCreateTime
        this.noteUpdateTime = noteUpdateTime
    }

    constructor(id:Int,title:String?,content:String?,noteUpdateTime: String?):this(){
        this.noteId =id
        this.noteTitle = title
        this.noteContent = content
        this.noteUpdateTime = noteUpdateTime
    }
}