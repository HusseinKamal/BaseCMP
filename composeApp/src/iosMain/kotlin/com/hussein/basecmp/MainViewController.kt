package com.hussein.basecmp

import androidx.compose.ui.window.ComposeUIViewController
import com.hussein.basecmp.app.App
import com.hussein.basecmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }