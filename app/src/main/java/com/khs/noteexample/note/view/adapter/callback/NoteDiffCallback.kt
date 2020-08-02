package com.khs.noteexample.note.view.adapter.callback


import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.khs.noteexample.model.NoteModel

class NoteDiffCallback: DiffUtil.ItemCallback<NoteModel>() {

    override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
        return oldItem.updateTime.equals(newItem.updateTime)
    }

}