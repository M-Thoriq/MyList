package com.thoriq.mylist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : ViewModel() {
    private val mRepository = NoteRepository(application)

    fun addNote(note: Note) {
        mRepository.addNote(note)
    }

    fun deleteNote(note: Note) {
        mRepository.deleteNote(note)
    }

    fun getAllNotes(): LiveData<List<Note>> = mRepository.getAllNotes()
    fun updateNote(note: Note) {
        mRepository.updateNote(note)
    }

}