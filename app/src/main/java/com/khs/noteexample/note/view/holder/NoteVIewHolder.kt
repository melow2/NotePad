package com.khs.noteexample.note.view.holder

import android.content.Context
import com.khs.noteexample.databinding.NoteBinder
import com.khs.noteexample.model.NoteModel


class NoteVIewHolder: BaseViewHolder {

    private lateinit var noteBinder: NoteBinder

    constructor(context: Context,noteBinder:NoteBinder):super(context,noteBinder.root)

    override fun bindDataToVIewHolder(item: NoteModel?, position: Int) {

    }
}