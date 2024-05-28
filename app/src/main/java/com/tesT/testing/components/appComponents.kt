package com.tesT.testing.components



import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.tesT.testing.R
import com.tesT.testing.ui.theme.nunitocustomfont



@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 0.1.dp),

        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = nunitocustomfont,
            fontWeight = FontWeight.SemiBold,
            shadow = Shadow(color = Color.Black,
                offset = Offset(10f, 10f),
                blurRadius = 15f
            ),

        )
        , color = colorResource(id = R.color.LetrasBlancas),
            textAlign = TextAlign.Center
    )
}
@Composable

fun TituloTextComponent(value: String) {

    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp),

        style = TextStyle(
            shadow = Shadow(color = Color.Black,
            offset = Offset(10f, 10f),
                blurRadius = 15f
                ),
            fontSize = 70.sp,
            fontFamily = nunitocustomfont,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 60.sp
            )
        ,color = colorResource(id = R.color.LetrasAzules),
        textAlign = TextAlign.Center
    )
}
@Composable

fun IngresaTextComponent(value: String) {
    Text(
        text = value,
        fontSize = 20.sp,
        fontFamily = nunitocustomfont,
        fontWeight = FontWeight.Light,
        color = colorResource(id = R.color.masgris),
        style = TextStyle(
            shadow = Shadow(color = Color.Gray,
                offset = Offset(3f, 3f),
                blurRadius = 10f
            )),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp)
    )
}
@Composable
fun NecesitasTextComponent(value: String) {
    Text(
        text = value,
        fontSize = 14.sp,
        fontFamily = nunitocustomfont,
        fontWeight = FontWeight.Light,
        color = colorResource(id = R.color.masgris),
        style = TextStyle(
            shadow = Shadow(color = Color.Gray,
                offset = Offset(3f, 3f),
                blurRadius = 10f
            )),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 10.dp)
    )
}

@Composable
fun MytextFieldComponent(labelValue: String, painterResource: Painter,
                         onTextSelected: (String) -> Unit
){

    val textValue = rememberSaveable(stateSaver = Saver(
        save = { it },
        restore = { it }
    )) {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue,
            fontFamily = nunitocustomfont,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            color = colorResource(id = R.color.Letrassecundarias)
        )},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        value = textValue.value,
        singleLine = true,
        maxLines = 1,
        onValueChange = {
             textValue.value = it
             onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }

    )


}

@Composable
fun PasswordtextFieldComponent(labelValue: String, painterResource: Painter,
                               onTextSelected: (String) -> Unit){

    val localFocusManager = LocalFocusManager.current

    val password = rememberSaveable(stateSaver = Saver(
        save = { it },
        restore = { it }
    )) {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable(stateSaver = Saver(
        save = { it },
        restore = { it }
    )) {
        mutableStateOf(value = false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue,
            fontFamily = nunitocustomfont,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            color = colorResource(id = R.color.Letrassecundarias)
        )},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        keyboardActions =  KeyboardActions{
            localFocusManager.clearFocus()

        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconmage =if(passwordVisible.value){
                Icons.Filled.Visibility
            } else{
                Icons.Filled.VisibilityOff

            }
            val description = if (passwordVisible.value){
                stringResource(id = R.string.contraoculta)
            } else{
                stringResource(id = R.string.contravisible)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconmage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )


}

@Composable
fun Checkboxcomponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedstate = remember {
            mutableStateOf(false)
        }
       Checkbox(checked = checkedstate.value,
           onCheckedChange ={ newValue ->
               checkedstate.value = newValue
           } )

        ClickableTextComponent(value = value, onTextSelected)

    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = " Al continuar aceptas nuestra "
    val privacyPolicyText = "politica de privacidad "
    val andtext = " y "
    val termsAndConditionsText = "terminos de uso"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style= SpanStyle(color = Color.Blue)) {
        pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andtext)
        withStyle(style= SpanStyle(color =Color.Blue)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }

    }
    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", span.item)

                if((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
            contentAlignment = Alignment.Center
        ){
            Button(
                onClick = {},
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(0.55f),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors( colorResource(id = R.color.LetrasAzules))
            ){
                Text( text =value,
                    fontFamily = nunitocustomfont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }
        }
}

@Composable
fun DividerTextComponent(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically


    ){


        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp

        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.or),
            fontSize = 18.sp,
            color = Color.Gray)
        Divider(
            modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp

        )
    }

}

@Composable
fun ClickableLoginTextComponent( tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if(tryingToLogin)"¿Ya tienes una cuenta? " else "¿Aun no tienes una cuenta? "
    val loginText = if (tryingToLogin)"Inicia sesión" else "Registrate"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style= SpanStyle(color = Color.Blue)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),

        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = nunitocustomfont,
            fontWeight = FontWeight.Light,
            color = colorResource(id = R.color.masgris),
            shadow = Shadow(color = Color.Gray,
                offset = Offset(3f, 3f),
                blurRadius = 10f
            ),
            textAlign = TextAlign.Center
        ),

        text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", span.item)

                if(span.item == loginText){
                    onTextSelected(span.item)
                }
            }
    })
}
































