package com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    //sınıfı fonksiyon gibi kullanıyoruz
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}