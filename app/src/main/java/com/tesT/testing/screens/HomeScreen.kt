package com.tesT.testing.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tesT.testing.R
import com.tesT.testing.components.ButtonComponent
import com.tesT.testing.components.NormalTextComponent
import com.tesT.testing.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel = viewModel()){

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
        ){
            NormalTextComponent(value = stringResource(id = R.string.Inicio))
            ButtonComponent(value = stringResource(id = R.string.CerrarSesión ), onButtonClicked = {
            signUpViewModel.logout()


            },
                isEnabled = true)

        }

    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}