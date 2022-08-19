package com.proyecto.apportizjonathan.retrofit.response

/*2 LOGIN. Crear la interfaz PatitasServicio en la carpeta retrofit --> PatitasServicio*/
data class ResponseLogin(
    var idPersona: Int,
    var rpta:Boolean,
    var email:Int,
    var nombre:String,
    var apellido:String

    /*devuelve esto cuando se logea*/
)
