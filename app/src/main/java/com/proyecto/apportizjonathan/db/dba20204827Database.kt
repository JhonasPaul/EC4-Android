package com.proyecto.apportizjonathan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto.apportizjonathan.db.dao.PersonaDao
import com.proyecto.apportizjonathan.db.entity.PersonaEntity


@Database(entities = [PersonaEntity::class], version = 1)
public abstract class dba20204827Database: RoomDatabase() {
    abstract fun personaDao(): PersonaDao


    companion object{

        @Volatile
        private var INSTANCE: dba20204827Database? = null

        /*crear la base de datos*/
        fun getDataBase(context: Context): dba20204827Database{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }


            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    dba20204827Database::class.java,
                    "tblfirebasejonathan").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}