package com.tesT.testing.data

sealed class UIEvent(){

    data class PrimerNombreChanged(val PrimerNombre: String) : UIEvent()
    data class ApellidosChanged(val Apellidos: String) : UIEvent()
    data class CorreoChanged(val correo: String) : UIEvent()
    data class contraseñaChanged(val contraseña: String) : UIEvent()
}
