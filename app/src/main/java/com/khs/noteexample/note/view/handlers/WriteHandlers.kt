package com.khs.noteexample.note.view.handlers

import android.content.Context
import android.view.View
import com.khs.noteexample.databinding.WriteBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.viewmodel.MainViewModel

class WriteHandlers(
    val context: Context,
    val binder: WriteBinder,
    val viewModel: MainViewModel
){

    fun onApplyButton(view: View){
        val noteTitle = binder.editTitle.text.toString()
        val noteContent = binder.editContent.text.toString()
        val noteCreateTime = System.currentTimeMillis().toString()
        val item = NoteModel(noteTitle,noteContent,noteCreateTime,noteCreateTime)
        viewModel.insertItem(item)
        (context as NoteActivity).supportFragmentManager.popBackStack()
    }

}