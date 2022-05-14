package com.droid.karlhauptapp.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droid.karlhauptapp.domain.Module

import com.droid.karlhauptapp.ui.theme.primaryBlue
import java.time.Duration

@Composable
fun Course(icon: ImageVector?= null, module: Module) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, primaryBlue, RoundedCornerShape(20))
            .padding(4.dp),
    ) {

        Row() {
            LoadIcon(icon = icon)

            Text(
                modifier = Modifier.padding(start = 5.dp, top = 10.dp, end = 4.dp),
                fontSize = 18.sp,
                text = module.courseName
            )
        }

        Row (
//            modifier = Modifier.padding(start = 5.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 40.dp, top = 5.dp),
                fontSize = 16.sp,
                text = module.courseType
            )
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 16.sp,
                text = module.courseDuration
            )
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun LoadIcon(icon: ImageVector?= null) {
    if(icon != null) {
        Icon(
            imageVector = icon,
            contentDescription = "Localized description",
            modifier = Modifier
                .size(35.dp)
                .padding(top = 15.dp),
            tint = primaryBlue
        )
    }
}

@Preview @Composable
fun PreviewCourse() {
    Course(
        icon = Icons.Outlined.Check,
        Module(courseName = "Application Development Practice", courseType = "Practical", courseDuration = "Yearly")
    )
}