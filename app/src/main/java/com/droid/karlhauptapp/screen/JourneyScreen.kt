package com.droid.karlhauptapp.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.droid.karlhauptapp.component.button.ActionButton
import com.droid.karlhauptapp.routing.Screen
import com.droid.karlhauptapp.ui.theme.primaryBlue

@Composable
fun JourneyScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {

            Label(
                icon = Icons.Outlined.CheckCircle,
                label = "Full Name: ",
                value = "Karl William Haupt"
            )

            Label(
                icon = Icons.Outlined.CheckCircle,
                label = "Course of Study: ",
                value = "App Dev"
            )

            Label(
                icon = Icons.Outlined.CheckCircle,
                label = "Department: ",
                value = "Information Technology"
            )

            Label(
                icon = Icons.Outlined.CheckCircle,
                label = "Student Number: ",
                value = "220236585"
            )
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                ActionButton(
                    content = "CURRENT MODULES",
                    icon = Icons.Outlined.AccountBox,
                    btnOnClick = { navController.navigate(Screen.CourseScreen.route) })
            }
    }

}

}

@Composable
private fun Label(icon: ImageVector?= null, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, primaryBlue, RoundedCornerShape(20))
            .padding(4.dp),
    ) {

        LoadIcon(icon = icon)

        Text(
            modifier = Modifier.padding(top = 5.dp, end = 4.dp),
            fontSize = 18.sp,
            text = label
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 18.sp,
            text = value
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun LoadIcon(icon: ImageVector ?= null) {
    if(icon != null) {
        Icon(
            imageVector = icon,
            contentDescription = "Localized description",
            modifier = Modifier
                .size(25.dp)
                .padding(top = 4.dp),
            tint = primaryBlue
        )
    }
}


@Composable @Preview
fun previewJourneyScreen() {
//    JourneyScreen()
}