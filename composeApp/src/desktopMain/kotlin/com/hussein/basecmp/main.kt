package com.hussein.basecmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hussein.basecmp.app.App
import com.hussein.basecmp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BaseCMP",
        ) {
            App()
        }
    }
}