package com.khs.noteexample.note.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.room.NoteDao
import com.khs.noteexample.note.room.NoteDatabase
import com.khs.noteexample.note.room.NoteEntity

class NoteRepository(application: Application): BaseRepository {

    private val noteDao: NoteDao

    companion object{
        @Volatile private var instance: NoteRepository?=null
        fun getInstance(application: Application): NoteRepository {
            return instance ?: NoteRepository(application)
        }
    }

    init {
        val db = NoteDatabase.getInstance(application)
        noteDao=db!!.noteDao()
    }

    override fun insert(item: NoteModel) {
        AsyncTask.execute {
            noteDao.insert(toEntity(item))
        }
    }

    override fun update(noteModel: NoteModel) {
        AsyncTask.execute {
            noteDao.update(toEntity(noteModel))
        }
    }

    override fun delete(noteModel: NoteModel) {
        AsyncTask.execute {
            noteDao.delete(toEntity(noteModel))
        }
    }

    override fun deleteAll() {

    }

    override fun getAll(): LiveData<List<NoteModel>> {
        val localList: LiveData<List<NoteEntity>> = noteDao.getAll()
        val reposList = toLiveDataListModel(localList)
        return reposList
    }

}