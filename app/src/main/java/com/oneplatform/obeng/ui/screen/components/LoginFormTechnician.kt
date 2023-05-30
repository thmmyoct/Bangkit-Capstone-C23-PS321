package com.oneplatform.obeng.ui.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oneplatform.obeng.R
import com.oneplatform.obeng.ui.theme.buttonPrimary
import com.oneplatform.obeng.ui.theme.colorPrimary
import com.oneplatform.obeng.ui.theme.dark_gray
import com.oneplatform.obeng.ui.theme.ghost_white
import com.oneplatform.obeng.ui.theme.gray
import com.oneplatform.obeng.ui.theme.light_gray

@Composable
fun LoginFormTechnician(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val loginText = "Log in to your account."
        val loginWord = "Log in"
        val loginAnnotatedString = buildAnnotatedString {
            append(loginText)
            addStyle(
                style = SpanStyle(
                    color = dark_gray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                ),
                start = 0,
                end = loginText.length
            )
            addStyle(
                style = SpanStyle(
                    color = ghost_white,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                ),
                start = 0,
                end = loginWord.length
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 20.dp),
            text = "Create your Technician Account!",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
        Text(
            text = "Email Address",
            style = MaterialTheme.typography.labelSmall.copy(color = gray),
            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
        )

        CustomStyleTextField(
            "Email Address",
            R.drawable.ic_email,
            KeyboardType.Email,
            VisualTransformation.None
        )

        Text(
            text = "Password",
            style = MaterialTheme.typography.labelSmall.copy(color = gray),
            modifier = Modifier.padding(bottom = 10.dp, top = 20.dp)
        )
        CustomStyleTextField(
            "Password",
            R.drawable.ic_password,
            KeyboardType.Password,
            PasswordVisualTransformation()
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            text = "Forgot Password?",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelMedium.copy(color = colorPrimary)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = buttonPrimary),
            modifier = Modifier
                .padding(top = 30.dp, bottom = 34.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = "Login",
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )
        }

        val signUpText = "Don't have an account? Sign Up"
        val signUpWord = "Sign Up"
        val signUpAnnotatedString = buildAnnotatedString {
            append(signUpText)
            addStyle(
                style = SpanStyle(
                    color = light_gray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                ),
                start = 0,
                end = signUpText.length
            )
            addStyle(
                style = SpanStyle(
                    color = colorPrimary,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                ),
                start = signUpText.indexOf(signUpWord),
                end = signUpText.length
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = signUpAnnotatedString,
            style = TextStyle(
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center
        )
    }

}
