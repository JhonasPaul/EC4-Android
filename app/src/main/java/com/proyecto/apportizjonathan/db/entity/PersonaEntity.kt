package com.proyecto.apportizjonathan.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dba20204827")
data class PersonaEntity(
    @PrimaryKey
    var idPersona: Int
    var email: String,
    var nombre: String,
    var apellido: String,
)
