package com.droid.karlhauptapp.component.AppDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.droid.karlhauptapp.ui.theme.KarlHauptAppTheme
import com.droid.karlhauptapp.ui.theme.primaryBlue

@Composable
fun AppDrawerHeader(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth().background(primaryBlue),
    ) {
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier.padding(top= 5.dp, end = 80.dp)
            ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back Button",
                tint = Color.White
            )
        }

        Text(
            text = "Karl Haupt App",
            modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(18.dp),
            color = Color.White
        )
    }
}

//@Preview @Composable
//fun AppDrawerHeaderPreview() {
//    KarlHauptAppTheme {
//        AppDrawerHeader()
//    }
//}