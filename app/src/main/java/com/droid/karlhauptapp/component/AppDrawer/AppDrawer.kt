package com.droid.karlhauptapp.component.AppDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.karlhauptapp.ui.theme.KarlHauptAppTheme
import com.droid.karlhauptapp.ui.theme.KarlHauptAppThemeSettings


@Composable
private fun ScreenNavigationButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colors

    val imageAlpha = if(isSelected) 1f else 0.6f
    val textColour = if(isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6f)

    val backgroundColour = if(isSelected) colors.primary.copy(alpha = 0.12f) else colors.surface

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        color = backgroundColour,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                imageVector = icon,
                contentDescription = "Screen Navigation Button",
                colorFilter = ColorFilter.tint(textColour),
                alpha = imageAlpha
            )

            Spacer(Modifier.width(16.dp))

            Text(
                text = label,
                style = MaterialTheme.typography.body2,
                color = textColour,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview @Composable
fun ScreenNavigationButtonPreview() {
    KarlHauptAppTheme {
        ScreenNavigationButton(
            icon = Icons.Filled.Home,
            label = "Notes",
            isSelected = true,
            onClick = { }
        )
    }
}

@Composable
private fun LightDarkThemeItem() {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "Turn on dark theme",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .align(alignment = Alignment.CenterVertically)
        )

        Switch(
            checked = KarlHauptAppThemeSettings.isDarkThemeEnabled,
            onCheckedChange = { KarlHauptAppThemeSettings.isDarkThemeEnabled = it },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .align(alignment = Alignment.CenterVertically)
        )

    }
}

@Preview
@Composable
fun LightDarkThemeItemPreview() {
    KarlHauptAppTheme {
        LightDarkThemeItem()
    }
}