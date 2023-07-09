package com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        //Notlarımız için hazır tanımlanmış renkleri sağlamak için bu listeyi yaptık
        val noteColors = listOf(Color.Yellow, Color.Red, Color.Blue, Color.Gray, Color.Magenta)
    }
}

class InvalidNoteException(message:String):Exception(message)


