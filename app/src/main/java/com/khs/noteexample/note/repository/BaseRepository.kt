package com.khs.noteexample.note.repository

import androidx.lifecycle.LiveData
import com.khs.noteexample.model.NoteModel

interface BaseRepository{
    fun insert(noteModel: NoteModel)
    fun update(noteModel: NoteModel)
    fun delete(noteModel: NoteModel)
    fun deleteAll()
    fun getAll():LiveData<List<NoteModel>>
}