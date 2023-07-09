package com.novacodestudios.cleanarchitecturenoteapp.di

import android.content.Context
import androidx.room.Room
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDataBase
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepositoryImpl
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNote
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNote
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNotes
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import com.novacodestudios.cleanarchitecturenoteapp.feature_note.presentation.notes.AddNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDataBase {
        return Room.databaseBuilder(context, NoteDataBase::class.java, NoteDataBase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(db:NoteDataBase):NoteRepository{
        return NoteRepositoryImpl(db.dao)
    }

    @Singleton
    @Provides
    fun providesNoteUseCases(repository:NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}