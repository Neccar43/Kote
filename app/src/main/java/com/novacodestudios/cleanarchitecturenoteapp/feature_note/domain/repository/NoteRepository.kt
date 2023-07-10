package com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.repository

import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


//Repository data source umuzdaki fonksiyonları ve verileri kullandığımız veri gelme durumlarını kontrol ettiğimiz yerdir
//örn. api çağrılarının durumu başarılı şekilde geldi mi yoksa bekliyor mu veya bir hata mı oluştu
//interface oluşturmamızın nedeni test için fake versiyonunu oluşturabilmemiz içindir
//repository ler verileri use caselere veririr use caseler verinin nerden geldiğini bilmez api den mi yoksa local den mi geliyor umursamazlar
interface NoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id:Int):Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}