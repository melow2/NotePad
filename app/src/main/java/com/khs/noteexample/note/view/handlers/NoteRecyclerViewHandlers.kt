package com.khs.noteexample.note.view.handlers

import android.content.Context
import android.os.Bundle
import android.view.View
import com.khs.noteexample.R
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.view.adapter.NoteAdapter
import com.khs.noteexample.note.view.fragment.UpdateFragment

class NoteRecyclerViewHandlers(
    val context: Context,
    val note:NoteModel
){

    fun onItemClicked(view: View,item:NoteModel){
        val updateFragment = UpdateFragment.newInstance()
        (context as NoteActivity).supportFragmentManager.beginTransaction()
            .add(R.id.container,updateFragment.apply {
                arguments=Bundle().apply {
                    putParcelable("note",note)
                } })
            .addToBackStack("UpdateFragment")
            .commit()
    }
}