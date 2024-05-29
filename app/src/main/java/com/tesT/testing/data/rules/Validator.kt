package com.tesT.testing.data.rules

object Validator {

    fun validatePrimerNombre(fName: String) :ValidationResult {
        return ValidationResult(
            (!fName.isNullOrEmpty() && fName.length >=4)
        )
    }

    fun validateApellidos(fapellidos: String) : ValidationResult{
        return ValidationResult(
            (!fapellidos.isNullOrEmpty() && fapellidos.length >=4)
        )

    }

    fun validateCorreo(fCorreo: String) : ValidationResult{
        return ValidationResult(
            (!fCorreo.isNullOrEmpty())
        )

    }
    fun validateContraseña(fContraseña: String) : ValidationResult{
        return ValidationResult(
            (!fContraseña.isNullOrEmpty() && fContraseña.length >= 4)
        )

    }
}

data class ValidationResult(
    val status : Boolean = false

)