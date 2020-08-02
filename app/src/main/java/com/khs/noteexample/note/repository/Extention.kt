package com.khs.noteexample.note.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.room.NoteEntity


fun NoteRepository.toListModel(noteEntity:List<NoteEntity>):List<NoteModel>{
    val itemList = mutableListOf<NoteModel>()
    noteEntity.map {
        itemList.add(NoteModel(it.noteId?:0,
            it.noteTitle?:"",
            it.noteContent?:"",
            it.noteCreateTime?:"",
            it.noteUpdateTime?:""))
    }
    return itemList
}

fun NoteRepository.toLiveDataListModel(localList:LiveData<List<NoteEntity>>):LiveData<List<NoteModel>> {
    return Transformations.map<List<NoteEntity>, List<NoteModel>>(localList,::toListModel)
}

fun NoteRepository.toEntity(note:NoteModel): NoteEntity {
    return when(note.id){
        null ->{
            // 새로운 노트 추가
            NoteEntity(note.title, note.content,note.createTime,note.updateTime)
        }
        else->{
            // 기존에 있는 노트 일 경우
            NoteEntity(
                note.id!!,
                note.title ?: "",
                note.content?:"",
                note.createTime?:"",
                note.updateTime?:""
            )
        }
    }
}