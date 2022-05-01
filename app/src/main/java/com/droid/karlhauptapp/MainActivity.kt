package com.droid.karlhauptapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.droid.karlhauptapp.routing.Router


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            AppDrawerHeaderPreview()

            Router()
        }
    }
}