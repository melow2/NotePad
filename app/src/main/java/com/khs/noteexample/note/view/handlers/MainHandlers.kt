package com.khs.noteexample.note.view.handlers

import android.content.Context
import android.provider.ContactsContract
import android.view.View
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity

class MainHandlers(val context: Context) {
    fun onAddButtonClicked(view:View){
        (context as NoteActivity).callWriteFragment()
    }
}