package com.proyecto.apportizjonathan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.proyecto.apportizjonathan.db.dba20204827Database
import com.proyecto.apportizjonathan.db.entity.PersonaEntity
import com.proyecto.apportizjonathan.repository.PersonaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonaViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PersonaRepository

    init {
        val personaDao = dba20204827Database.getDataBase(application)
            .personaDao()
        repository = PersonaRepository(personaDao)
    }

    fun insertar(personaEntity: PersonaEntity) =
         viewModelScope.launch(Dispatchers.IO){
        repository.insertar(personaEntity)
    }

    fun obtener(): LiveData<PersonaEntity> {
        return repository.obtener()
    }
}