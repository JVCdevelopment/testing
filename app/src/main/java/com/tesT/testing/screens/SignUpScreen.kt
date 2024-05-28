package com.tesT.testing.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tesT.testing.R
import com.tesT.testing.components.ButtonComponent

import com.tesT.testing.components.Checkboxcomponent
import com.tesT.testing.components.ClickableLoginTextComponent
import com.tesT.testing.components.DividerTextComponent

import com.tesT.testing.components.MytextFieldComponent
import com.tesT.testing.components.NormalTextComponent
import com.tesT.testing.components.TituloTextComponent
import com.tesT.testing.components.IngresaTextComponent
import com.tesT.testing.components.PasswordtextFieldComponent
import com.tesT.testing.data.LoginViewModel
import com.tesT.testing.data.UIEvent

import com.tesT.testing.navigation.Screen
import com.tesT.testing.navigation.SystemBackButtonHandler
import com.tesT.testing.navigation.trackFinderAppRouter


@Composable
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE6E6E6))
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFE6E6E6))
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            NormalTextComponent(value = stringResource(id = R.string.Hello))
            TituloTextComponent(value = stringResource(id = R.string.Titulo))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ){
                Column {
                    IngresaTextComponent(value = stringResource(id = R.string.subtitulo))

                    MytextFieldComponent(labelValue = stringResource(id = R.string.PrimerNombre),
                        painterResource = painterResource(id = R.drawable.noun_profile_709597),
                        onTextSelected = {
                        loginViewModel.onEvent(UIEvent.PrimerNombreChanged(it))
                        }
                        )
                    MytextFieldComponent(labelValue = stringResource(id = R.string.Apellidos),
                        painterResource = painterResource(id = R.drawable.noun_profile_709597),
                        onTextSelected = {
                        loginViewModel.onEvent(UIEvent.ApellidosChanged(it))
                        }
                        )
                    MytextFieldComponent(labelValue = stringResource(id = R.string.correo),
                        painterResource = painterResource(id = R.drawable.email_icon),
                        onTextSelected = {
                        loginViewModel.onEvent(UIEvent.CorreoChanged(it))
                        }
                        )
                    PasswordtextFieldComponent(labelValue = stringResource(id = R.string.contraseña),
                        painterResource = painterResource(id = R.drawable.candado_icon),
                        onTextSelected = {
                        loginViewModel.onEvent(UIEvent.contraseñaChanged(it))
                        }
                        )
                    Checkboxcomponent(value = stringResource(id = R.string.terminos),
                        onTextSelected = {
                            trackFinderAppRouter.navigateTo(Screen.TermsAndConditionsScreen)

                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    ButtonComponent(value = stringResource(id = R.string.Boton)

                        )
                    Spacer(modifier = Modifier.height(10.dp))
                    DividerTextComponent(

                    )
                    ClickableLoginTextComponent(
                        tryingToLogin = true, onTextSelected = {
                            trackFinderAppRouter.navigateTo(Screen.LoginScreen)
                        }
                    )



                }

            }




        }




    }
    SystemBackButtonHandler{
        trackFinderAppRouter.navigateTo(Screen.LoginScreen)
    }
}

@Preview
@Composable
fun DefaultPreviewOfsignUpScreen(){
    SignUpScreen()
}