package com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case

//not use caslerini tek tek viewmodelin constructor ına vermek constructor u bir sürü parametre ile doldurabileceği için
// bütün use case leri kapsayacak tek bir data class oluşturduk (wrapper class) böylece daha temiz bir kod elde edebiliriz
data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote:GetNote
)
