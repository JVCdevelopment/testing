package com.tesT.testing.data

sealed class SignUpUIEvent(){

    data class PrimerNombreChanged(val PrimerNombre: String) : SignUpUIEvent()
    data class ApellidosChanged(val Apellidos: String) : SignUpUIEvent()
    data class CorreoChanged(val correo: String) : SignUpUIEvent()
    data class contraseñaChanged(val contraseña: String) : SignUpUIEvent()

    data class PrivacyPolicyCheckBoxClicked (val status: Boolean) : SignUpUIEvent()

    object RegisterButtonClicked : SignUpUIEvent(){

    }
}
