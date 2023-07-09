package com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.novacodestudios.cleanarchitecturenoteapp.ui.theme.md_theme_light_primary

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

        val noteColors = listOf(
            Color(0xFFFFC107),  // Turuncu
            Color(0xFF3F51B5),  // Mavi
            Color(0xFFE91E63),  // Pembe
            Color(0xFF4CAF50),  // Yeşil
            Color(0xFF9C27B0)   // Mor
        )
    }
}

class InvalidNoteException(message:String):Exception(message)


