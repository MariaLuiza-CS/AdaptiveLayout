package com.example.adaptivelayout

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun WindowSizeClassApi(activity: Activity) {
    val windowSize = calculateWindowSizeClass(activity = activity)

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            //BottomNavigation()
        }

        WindowWidthSizeClass.Medium -> {
            //NavigationRail()
        }

        WindowWidthSizeClass.Expanded -> {
            //PermanentNavigationDrawer()
        }

        else -> {
            //BottomNavigation()
        }
    }
}