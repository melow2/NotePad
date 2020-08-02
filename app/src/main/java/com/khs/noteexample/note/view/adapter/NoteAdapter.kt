package com.khs.noteexample.note.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.khs.noteexample.R
import com.khs.noteexample.databinding.NoteBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.handlers.NoteRecyclerViewHandlers
import com.khs.noteexample.note.view.adapter.callback.NoteDiffCallback
import com.khs.noteexample.note.view.holder.NoteVIewHolder


class NoteAdapter(
    val context: Context
):ListAdapter<NoteModel,NoteVIewHolder>(NoteDiffCallback()) {

    private lateinit var noteBinder: NoteBinder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVIewHolder {
        noteBinder = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_note,
            parent,
            false
        )
        return NoteVIewHolder(context, noteBinder)
    }

    override fun onBindViewHolder(holder: NoteVIewHolder, position: Int) {
        val note = getItem(holder.adapterPosition)
        note?.let{
            noteBinder.note = note
            noteBinder.handlers = NoteRecyclerViewHandlers(context,note)
            holder.bindDataToVIewHolder(note, position)
        }
    }

    fun getNoteAt(position: Int): NoteModel {
        return getItem(position)
    }
}
