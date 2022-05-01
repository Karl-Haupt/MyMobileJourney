package com.droid.karlhauptapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.droid.karlhauptapp.component.button.ActionButton
import com.droid.karlhauptapp.routing.Screen
import com.droid.karlhauptapp.ui.theme.primaryBlue

private var shouldShowDialog = mutableStateOf(false)

@Composable
fun WelcomeScreen(navController: NavController) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            PreviewHome(navController)
    }
}

//@Preview(showBackground = true)
@Composable
fun PreviewHome(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to My Jetpack Compose Journey",
            fontSize = 16.sp,
            color = primaryBlue,
            style = MaterialTheme.typography.body1,
            maxLines = 1
        )

        Spacer(modifier = Modifier.width(4.dp))

        ActionButton(content = "INFO", icon = Icons.Outlined.Info, btnOnClick = {if(shouldShowDialog != null) shouldShowDialog.value = true})
        RenderDialog(shouldShowDialog)
        ActionButton(content = "START JOURNEY", icon = Icons.Outlined.AccountCircle, btnOnClick = { navController.navigate(Screen.JourneyRoute.route) })

    }

}


@Composable
private fun RenderDialog(shouldShowDialog: MutableState<Boolean>) {
    if(shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = true;
            },
            title = {
                Text(text = "My Journey")
            },
            text = { Text(text = stringResource(id = com.droid.karlhauptapp.R.string.my_journey)) },

            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF42b9f5)),
                    onClick = {
                        shouldShowDialog.value = false;
                    }
                ) {
                    Text(
                        text = "Interesting",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        shouldShowDialog.value = false;
                    }
                ) {
                    Text(
                        text = "Boring",
                        color = Color.White
                    )
                }
            }
        )
    }
}