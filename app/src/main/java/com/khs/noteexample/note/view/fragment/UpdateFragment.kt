package com.khs.noteexample.note.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khs.noteexample.R
import com.khs.noteexample.databinding.UpdateBinder
import com.khs.noteexample.model.NoteModel
import com.khs.noteexample.note.view.NoteActivity
import com.khs.noteexample.note.viewmodel.MainViewModel

class UpdateFragment:Fragment(){

    private lateinit var binding:UpdateBinder
    private lateinit var viewModel: MainViewModel
    private lateinit var note:NoteModel

    private val STATUS_MODIFY = "MODIFY"
    private val STATUS_READ = "READ"
    private lateinit var CURRENT_STATUS:String

    companion object{
        private var instance:UpdateFragment?=null
        fun newInstance():UpdateFragment{
            return instance?: UpdateFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        note = arguments?.getParcelable("note")!!
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update,container,false)
        binding.note = note
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        CURRENT_STATUS = STATUS_READ
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_update,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_modify ->{
                setupLayout(item)
            }
            R.id.menu_delete->{
                viewModel.delete(note)
                popBackStack()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupLayout(item: MenuItem) {
        when(CURRENT_STATUS){
            STATUS_READ ->{
                CURRENT_STATUS = STATUS_MODIFY
                item.setIcon(R.drawable.icon_checkmark_60px)
                binding.editTitle.isEnabled = true
                binding.editContent.isEnabled = true
                binding.editContent.requestFocus()
            }
            STATUS_MODIFY->{
                CURRENT_STATUS = STATUS_READ
                item.setIcon(R.drawable.icons_edit_file_50px)
                binding.editTitle.isEnabled = false
                binding.editContent.isEnabled = false
                updateItem()
            }
        }
    }

    private fun updateItem() {
        this.note.title = binding.editTitle.text.toString()
        this.note.content = binding.editContent.text.toString()
        this.note.updateTime = System.currentTimeMillis().toString()
        viewModel.updateItem(note)
        MainFragment.newInstance().recyclerViewClear()
        popBackStack()
    }

    private fun popBackStack(){
        (context as NoteActivity).supportFragmentManager.popBackStack()
    }
}