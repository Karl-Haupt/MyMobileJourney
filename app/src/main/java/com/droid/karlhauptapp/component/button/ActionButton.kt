package com.droid.karlhauptapp.component.button

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.karlhauptapp.ui.theme.primaryBlue


@SuppressLint("UnrememberedMutableState")
@Composable
fun ActionButton(content: String, icon: ImageVector ?= null, btnOnClick: () -> Unit) {
    Row(
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = primaryBlue),
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color(0xFF42cef5))),
            onClick = { btnOnClick() }
            ) {

            LoadIcon(icon)

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                maxLines = 1,
                color = Color.White,
                text = content.uppercase()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewActionButton() {
//    ActionButton(content = "Info", icon = Icons.Outlined.Info);
}

@Composable
private fun LoadIcon(icon: ImageVector ?= null) {
    if(icon != null) {
        Icon(
            imageVector = icon,
            contentDescription = "Localized description",
            modifier = Modifier
                .size(20.dp),
            tint = Color.White
        )
    }
}