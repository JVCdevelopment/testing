package com.tesT.testing.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent (event: UIEvent){
        when(event){

            is UIEvent.PrimerNombreChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    PrimerNombre = event.PrimerNombre
                )
                printstate()

            }
            is UIEvent.ApellidosChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    Apellidos = event.Apellidos
                )
                printstate()
        }
            is UIEvent.CorreoChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    correo = event.correo
                )
                printstate()
            }
            is UIEvent.contraseñaChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    contraseña = event.contraseña
                )
                printstate()
            }
            }

    }

    private fun printstate(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

}