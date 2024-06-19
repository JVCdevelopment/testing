package com.tesT.testing.data

 data class RegistrationUIState(
    var PrimerNombre: String = "",
    var Apellidos: String = "",
    var correo: String = "",
    var contraseña: String = "",
    var privacyPolicyAccepted: Boolean = false,


    var PrimerNombreError :Boolean = false,
    var ApellidosError :Boolean = false,
    var CorreoError :Boolean = false,
    var ContraseñaError :Boolean = false,
    var privacyPolicyError :Boolean = false ,


)
