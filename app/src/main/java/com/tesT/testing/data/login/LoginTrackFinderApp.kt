package com.tesT.testing

import android.app.Application
import com.google.firebase.FirebaseApp

class LoginTrackFinderApp : Application(){
    override  fun onCreate(){
        super.onCreate()

        FirebaseApp.initializeApp(this)


    }

}