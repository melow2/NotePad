package com.khs.noteexample.note.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.khs.noteexample.model.NoteModel

abstract class BaseViewHolder : RecyclerView.ViewHolder{

    private lateinit var context:Context

    constructor(context:Context,view: View):super(view){
        this.context = context
    }

    abstract fun bindDataToVIewHolder(item: NoteModel?, position:Int)

}