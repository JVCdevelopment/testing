package com.tesT.testing.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tesT.testing.navigation.Screen
import com.tesT.testing.navigation.trackFinderAppRouter
import com.tesT.testing.screens.LoginScreen
import com.tesT.testing.screens.SignUpScreen
import com.tesT.testing.screens.TermsAndConditionsScreen

@Composable
fun trackFinder(){

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        Crossfade(targetState = trackFinderAppRouter
            .currentScreen) {currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen ->{
                    TermsAndConditionsScreen()

            }
                is Screen.LoginScreen ->{
                    LoginScreen()
                }
            }


        }
    }
}


