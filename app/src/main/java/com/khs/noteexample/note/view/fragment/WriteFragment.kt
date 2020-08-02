package com.khs.noteexample.note.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khs.noteexample.R
import com.khs.noteexample.databinding.WriteBinder
import com.khs.noteexample.note.view.handlers.WriteHandlers
import com.khs.noteexample.note.viewmodel.MainViewModel

class WriteFragment:Fragment(){

    private lateinit var binding:WriteBinder
    private lateinit var viewModel:MainViewModel

    companion object{
        private var instance:WriteFragment?=null
        fun newInstance():WriteFragment{
            return instance?: WriteFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_write,container,false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        binding.handlers = WriteHandlers(context!!, binding, viewModel)
        return binding.root
    }
}