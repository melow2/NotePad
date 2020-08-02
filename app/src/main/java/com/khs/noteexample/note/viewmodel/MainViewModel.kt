package com.khs.noteexample.note.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.repository.NoteRepository


class MainViewModel:AndroidViewModel{

    private lateinit var noteRepository: NoteRepository
    private lateinit var liveList:LiveData<List<NoteModel>>

    constructor(application: Application):super(application){
        noteRepository = NoteRepository.getInstance(application)
        liveList = noteRepository.getAll()
    }

    fun insertItem(item:NoteModel){
        noteRepository.insert(item)
    }

    fun updateItem(item:NoteModel){
        noteRepository.update(item)
    }

    fun delete(item:NoteModel){
        noteRepository.delete(item)
    }

    fun getItem():LiveData<List<NoteModel>>{
        return liveList
    }

}