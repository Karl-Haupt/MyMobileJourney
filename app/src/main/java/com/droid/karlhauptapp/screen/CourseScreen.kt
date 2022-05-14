package com.droid.karlhauptapp.screen

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.droid.karlhauptapp.component.Course
import com.droid.karlhauptapp.component.button.ActionButton
import com.droid.karlhauptapp.domain.Module
import com.droid.karlhauptapp.routing.Screen

private var shouldShowDialog = mutableStateOf(false)

@Composable
fun CourseScreen(navController: NavController) {
    var courseList = listOf(
        Module(courseName = "Application Development Practice 3", courseType = "Practical", courseDuration = "Yearly"),
        Module(courseName = "Application Development Theory 3", courseType = "Theory", courseDuration = "Yearly"),
        Module(courseName = "ICT Electives 3", courseType = "Practical", courseDuration = "Semester"),
        Module(courseName = "Information Systems 3", courseType = "Theory", courseDuration = "Yearly"),
        Module(courseName = "Professional Practice 3", courseType = "Theory", courseDuration = "Yearly"),
        Module(courseName = "Project 3", courseType = "Practical", courseDuration = "Yearly"),
        Module(courseName = "Project Management 3", courseType = "Theory", courseDuration = "Semester"),
        Module(courseName = "Project Presentation 3", courseType = "Theory", courseDuration = "Yearly"),
    )
    var scrollstate = rememberScrollState()

    Column(
        modifier = Modifier.padding(top = 60.dp).verticalScroll(scrollstate),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        courseList.forEach { m -> Course(icon = Icons.Outlined.Check, module = m) }
    
        Row(
            modifier = Modifier.padding(2.dp),
        ) {
            ActionButton(
                content = "Back",
                icon = Icons.Outlined.ArrowBack,
                btnOnClick = { navController.navigate(Screen.JourneyRoute.route) }
            )

            ActionButton(
                content = "Good Bye",
                icon = Icons.Outlined.ExitToApp,
                btnOnClick = {if(shouldShowDialog != null) shouldShowDialog.value = true}
            )
            RenderDialog(shouldShowDialog)
        }
    }

}

@Composable
private fun RenderDialog(shouldShowDialog: MutableState<Boolean>) {
    val activity = (LocalContext.current as? Activity)

    if(shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = true;
            },
            title = {
                Text(text = "Leaving")
            },
            text = { Text(text = "Leaving now?") },

            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF42b9f5)),
                    onClick = {
                        shouldShowDialog.value = false;
                    }
                ) {
                    Text(
                        text = "No",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        shouldShowDialog.value = false;
                        activity?.finish()
                    }
                ) {
                    Text(
                        text = "Yes",
                        color = Color.White
                    )
                }
            }
        )
    }
}

//@Preview @Composable
//fun PreviewCourseScreen() {
//    CourseScreen()
//}