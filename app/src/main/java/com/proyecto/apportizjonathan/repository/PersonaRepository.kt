package com.proyecto.apportizjonathan.repository

import androidx.lifecycle.LiveData
import com.proyecto.apportizjonathan.db.dao.PersonaDao
import com.proyecto.apportizjonathan.db.entity.PersonaEntity

class PersonaRepository(private val personaDao: PersonaDao) {
    suspend fun insertar(personaEntity: PersonaEntity) {
        personaDao.insertar(personaEntity)
    }

    fun obtener(): LiveData<PersonaEntity> {
        return personaDao.obtener()
    }
}