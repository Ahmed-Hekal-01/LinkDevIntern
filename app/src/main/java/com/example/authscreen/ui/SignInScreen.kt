package com.example.authscreen.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authscreen.R
import com.example.authscreen.ui.theme.AuthscreenTheme

// Q
/*
* refactor the colors into the theme always??
* what are you ganna do with the Spacer problem for small screens?
* the background image vector need to be added
* is the AnimatedVisibility a good solution when ime is visible?
* is the hard coded values ok? or need to be extracted at some high level abstraction
* is the screen good structured? and is there any best practices for screen structure?
* */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SignIn() {
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .padding(20.dp)
            .fillMaxSize()
    ) {

        FloatingActionButton(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 30.dp)
                .size(55.dp)
                .align(Alignment.TopStart)
                .border(
                    width = 1.dp,
                    color = Color(0xFFEBEAEC),
                    shape = RoundedCornerShape(50.dp)
                ),
            onClick = {},
            shape = RoundedCornerShape(50.dp),
            containerColor = Color.White,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.0.dp),
        ) {
            Image(painterResource(R.drawable.back), null)
        }
        val isImeVisible = WindowInsets.isImeVisible
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 133.dp),
                text = stringResource(R.string.welcome_message),
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF3F414E)
            )
            AnimatedVisibility(
                visible = !isImeVisible,
                enter = fadeIn(animationSpec = tween(100)) + expandVertically(
                    animationSpec = tween(100), expandFrom = Alignment.Top
                ),
                exit = fadeOut(animationSpec = tween(100)) + shrinkVertically(
                    animationSpec = tween(100), shrinkTowards = Alignment.Top
                )
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(33.dp))

                    AuthButton(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF7583CA),
                                shape = RoundedCornerShape(38.dp)
                            )
                            .fillMaxWidth()
                            .height(63.dp),
                        icon = R.drawable.facebook,
                        label = stringResource(R.string.facebook_button_label),
                        contentColor = Color.White
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    AuthButton(
                        modifier = Modifier
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(38.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEBEAEC),
                                shape = RoundedCornerShape(38.dp)
                            )
                            .fillMaxWidth()
                            .height(63.dp),
                        icon = R.drawable.google,
                        label = stringResource(R.string.google_button_label),
                        contentColor = Color.Black
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        modifier = Modifier.clickable {

                        },
                        text = stringResource(R.string.log_in_by_email_label).uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFFA1A4B2)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(63.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(
                        text = stringResource(R.string.email_text_field_label),
                        color = Color(0xFFA1A4B2)
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF2F3F7),
                    unfocusedContainerColor = Color(0xFFF2F3F7),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color(0xFFA1A4B2),
                    unfocusedTextColor = Color(0xFFA1A4B2),
                    cursorColor = Color(0xFFA1A4B2)
                )

            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(63.dp),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(
                        text = stringResource(R.string.password_text_field_label),
                        color = Color(0xFFA1A4B2)
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF2F3F7),
                    unfocusedContainerColor = Color(0xFFF2F3F7),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color(0xFFA1A4B2),
                    unfocusedTextColor = Color(0xFFA1A4B2),
                    cursorColor = Color(0xFFA1A4B2)
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            AuthButton(
                label = stringResource(R.string.log_in_button_label),
                contentColor = Color.White,
                modifier = Modifier
                    .background(
                        color = Color(0xFF8E97FD),
                        shape = RoundedCornerShape(38.dp)
                    )
                    .fillMaxWidth()
                    .height(63.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.clickable {

                },
                text = stringResource(R.string.forget_password_label),
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xFF3F414E),
            )

            Spacer(modifier = Modifier.height(60.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(R.string.already_have_an_account),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFFA1A4B2),
                )

                Text(
                    text = " " + stringResource(R.string.sign_up),
                    color = Color(0xFF8E97FD),
                    modifier = Modifier
                        .clickable {}
                )
            }

        }
    }
}


@Composable
fun AuthButton(
    @DrawableRes icon: Int? = null,
    label: String,
    modifier: Modifier,
    contentColor: Color
) {
    Button(
        modifier = modifier,
        onClick = {},
        shape = RoundedCornerShape(38.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            if (icon != null) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "Google logo",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterStart)
                )
            }
            Text(
                text = label.uppercase(),
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.labelLarge
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    AuthscreenTheme {
        SignIn()
    }
}