package com.tesT.testing.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.tesT.testing.data.rules.Validator
import com.tesT.testing.navigation.Screen
import com.tesT.testing.navigation.trackFinderAppRouter
import com.tesT.testing.screens.HomeScreen

class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent (event: UIEvent){
        validateDataWithRules()
        when(event) {

            is UIEvent.PrimerNombreChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    PrimerNombre = event.PrimerNombre
                )

                printstate()

            }

            is UIEvent.ApellidosChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    Apellidos = event.Apellidos
                )

                printstate()
            }

            is UIEvent.CorreoChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    correo = event.correo
                )
                printstate()
            }

            is UIEvent.contraseñaChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    contraseña = event.contraseña
                )
                printstate()
            }

            is UIEvent.RegisterButtonClicked -> {
                signUp()
            }

            is UIEvent.PrivacyPolicyCheckBoxClicked ->{
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )

            }
        }

    }

    private fun signUp() {
        Log.d(TAG, "Inside_signUp")
        printstate()

        createUserInFirebase(
            Correo = registrationUIState.value.correo,
            Contraseña = registrationUIState.value.contraseña

        )
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validatePrimerNombre(
            fName = registrationUIState.value.PrimerNombre
        )
        val lNameResult = Validator.validateApellidos(
            fapellidos = registrationUIState.value.Apellidos
        )
        val emailResult = Validator.validateCorreo(
            fCorreo = registrationUIState.value.correo
        )
        val passwordResult = Validator.validateContraseña(
            fContraseña = registrationUIState.value.contraseña
        )
        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )


        Log.d(TAG, "Inside_validatedatawithrules")
        Log.d(TAG, "fName= $fNameResult")
        Log.d(TAG, "fapellidos= $lNameResult")
        Log.d(TAG, "emailResult= $emailResult")
        Log.d(TAG, "passwordResult = $passwordResult")
        Log.d(TAG, "privacyPolicyResult = $privacyPolicyResult")

        registrationUIState.value = registrationUIState.value.copy(
            PrimerNombreError = fNameResult.status,
            ApellidosError = lNameResult.status,
            CorreoError = emailResult.status,
            ContraseñaError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status


        )
        allValidationsPassed.value = fNameResult.status && lNameResult.status &&
                emailResult.status && passwordResult.status && privacyPolicyResult.status

    }

    private fun printstate(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUIState.value.toString())
    }

    private fun createUserInFirebase(Correo: String, Contraseña: String){
        signUpInProgress.value = true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(Correo, Contraseña)
            .addOnCompleteListener{
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, "isSuccesful = ${it.isSuccessful}")
                signUpInProgress.value = false
                if(it.isSuccessful){
                    trackFinderAppRouter.navigateTo(Screen.HomeScreen)

                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception= ${it.message}")
                Log.d(TAG, "Exception= ${it.localizedMessage}")


            }
    }

    fun logout(){
        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = FirebaseAuth.AuthStateListener {
            if(it.currentUser == null){
                    Log.d(TAG, "inside Cerrar Sesion")
                    trackFinderAppRouter.navigateTo(Screen.LoginScreen)
            }else{
                Log.d(TAG, "no se pudo cerrar sesion")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)


    }


}