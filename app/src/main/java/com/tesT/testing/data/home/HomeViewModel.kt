package com.tesT.testing.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.tesT.testing.navigation.Screen
import com.tesT.testing.navigation.trackFinderAppRouter

class HomeViewModel : ViewModel (){

    private val TAG = HomeViewModel::class.simpleName


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

    val isUserLoggedIn : MutableLiveData<Boolean> = MutableLiveData()
    fun checkForActiveSession(){

        if(FirebaseAuth.getInstance().currentUser != null) {
            Log.d("TAG", "valid session: ")
            isUserLoggedIn.value = true


        }else{
            Log.d("TAG", "user is not logged in: ")
            isUserLoggedIn.value = false

        }
    }
}