package com.tesT.testing

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.tesT.testing.data.login.LoginUIEvent
import com.tesT.testing.data.login.LoginUIState
import com.tesT.testing.data.rules.Validator
import com.tesT.testing.navigation.Screen
import com.tesT.testing.navigation.trackFinderAppRouter

class LoginViewModel : ViewModel() {


    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationsPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: LoginUIEvent) {

        when (event) {
            is LoginUIEvent.CorreoChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    correo = event.correo
                )

            }

            is LoginUIEvent.contraseñaChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    contraseña = event.contraseña
                )

            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()


            }


        }
        validateLoginUIDataWithRules()
    }


    private fun validateLoginUIDataWithRules() {
        val emailresult = Validator.validateCorreo(
            fCorreo = loginUIState.value.correo
        )

        val passwordResult = Validator.validateContraseña(
            fContraseña = loginUIState.value.contraseña
        )

        loginUIState.value = loginUIState.value.copy(
            CorreoError = emailresult.status,
            ContraseñaError = passwordResult.status
        )

        allValidationsPassed.value = emailresult.status && passwordResult.status
    }

    private fun login() {
        loginInProgress.value = true
        val correo = loginUIState.value.correo
        val contraseña = loginUIState.value.contraseña
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(correo, contraseña)
            .addOnCompleteListener {
                loginInProgress.value = false
                Log.d(TAG, "Inside_Login_Success")
                Log.d(TAG, "login: ${it.isSuccessful}")

                if (it.isSuccessful) {
                    loginInProgress.value = false
                    trackFinderAppRouter.navigateTo(Screen.HomeScreen)



                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_Login_Failure")
                Log.d(TAG, "login: ${it.localizedMessage}")
                loginInProgress.value = false

            }
    }

}