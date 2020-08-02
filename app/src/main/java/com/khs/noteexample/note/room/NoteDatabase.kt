package com.khs.noteexample.note.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase:RoomDatabase(){

    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile private var instance: NoteDatabase?=null
        fun getInstance(context: Context): NoteDatabase?{
            instance ?: synchronized(NoteDatabase::class){
                instance = Room.databaseBuilder(context,
                    NoteDatabase::class.java,
                    "NOTE_DATABASE").fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            return instance
        }

        private val roomCallback:Callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
               // PopulateAsyncTask(instance).execute()
            }
        }

        class PopulateAsyncTask(var db: NoteDatabase?):AsyncTask<Unit,Unit,Unit>() {
            private var noteDao: NoteDao? = db?.noteDao()
            override fun doInBackground(vararg params: Unit?) {
                noteDao?.insert(NoteEntity("test1", "test1"))
                noteDao?.insert(NoteEntity("test2", "test2"))
                noteDao?.insert(NoteEntity("test3", "test3"))
            }
        }
    }

}


