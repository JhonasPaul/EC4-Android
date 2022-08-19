package com.proyecto.apportizjonathan.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proyecto.apportizjonathan.db.entity.PersonaEntity

@Dao
interface PersonaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertar(vararg persona: PersonaEntity)


    @Query("select * from dba20204827 limit 1")
    fun obtener(): LiveData<PersonaEntity>
}