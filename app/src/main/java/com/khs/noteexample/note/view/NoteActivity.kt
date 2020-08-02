package com.khs.noteexample.note.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.khs.noteexample.R
import com.khs.noteexample.note.view.fragment.MainFragment
import com.khs.noteexample.note.view.fragment.WriteFragment
import com.khs.noteexample.note.viewmodel.MainViewModel

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            callMainFragment()
        }
    }

    private fun callMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container,MainFragment.newInstance())
            .commitNow()
    }

    fun callWriteFragment(){
        supportFragmentManager.beginTransaction()
            .add(R.id.container,WriteFragment.newInstance())
            .addToBackStack("WriteFragment")
            .commit()
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount==0) super.onBackPressed()
        else{ supportFragmentManager.popBackStack() }
    }
}
