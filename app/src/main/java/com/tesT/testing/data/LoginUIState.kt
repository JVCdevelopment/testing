package com.tesT.testing.data

data class LoginUIState (

        var correo: String = "",
        var contraseña: String = "",

        var CorreoError :Boolean = false,
        var ContraseñaError :Boolean = false,
) {

}