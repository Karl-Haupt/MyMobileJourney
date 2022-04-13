package com.droid.karlhauptapp.component.AppDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.karlhauptapp.ui.theme.KarlHauptAppTheme
import com.droid.karlhauptapp.ui.theme.primaryBlue

@Composable
private fun AppDrawerHeader() {
    Row(
        modifier = Modifier.fillMaxWidth().background(primaryBlue),
        horizontalArrangement = Arrangement.Center
    ) {
//        Image(
//            imageVector = Icons.Outlined.Menu,
//            modifier = Modifier.padding(16.dp),
//            contentDescription = "Drawer Header Icon",
//            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
//        )

        Text(
            text = "Karl Haupt App",
            modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(18.dp),
            color = Color.White
        )
    }
}

@Preview @Composable
fun AppDrawerHeaderPreview() {
    KarlHauptAppTheme {
        AppDrawerHeader()
    }
}