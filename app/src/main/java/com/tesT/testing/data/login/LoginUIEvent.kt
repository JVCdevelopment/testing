package com.tesT.testing.data

sealed class LoginUIEvent{


    data class CorreoChanged(val correo: String) : LoginUIEvent()
    data class contraseñaChanged(val contraseña: String) : LoginUIEvent()

    object LoginButtonClicked : LoginUIEvent(){

    }
}