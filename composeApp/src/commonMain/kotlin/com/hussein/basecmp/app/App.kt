package com.hussein.basecmp.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import basecmp.composeapp.generated.resources.Res
import basecmp.composeapp.generated.resources.mark_as_favorite
import com.hussein.basecmp.core.domain.language.Localization
import com.hussein.basecmp.core.domain.language.Language
import com.hussein.basecmp.databasename.data.local.DataStoreRepository
import com.hussein.basecmp.databasename.data.local.createDataStore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import kotlin.random.Random

@Composable
@Preview
fun App(context: Any? = null) {
    MaterialTheme {
        val scope = rememberCoroutineScope()
        var showContent by remember { mutableStateOf(false) }
        val dataStoreRepository = remember {
            DataStoreRepository(dataStore = createDataStore(context = context))
        }
        var savedTimestamp: Long? by remember { mutableStateOf(null) }

        LaunchedEffect(Unit) {
            dataStoreRepository.readTimestamp().collectLatest {
                savedTimestamp = it
            }
        }

        val localization = koinInject<Localization>()
        var languageIso by mutableStateOf(
            Language.English.iso
        )
        val selectedLanguage by derivedStateOf {
            Language.entries.first { it.iso == languageIso }
        }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Saved value: ${if (savedTimestamp == null) "Empty" else "$savedTimestamp"}")
            Button(onClick = {
                showContent = !showContent
                scope.launch {
                    dataStoreRepository.saveTimestamp(
                        Random.nextLong(
                            from = 100,
                            until = 1000
                        )
                    )
                }
            }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {


                MainScreen(
                    language = selectedLanguage,
                    onLanguageChange = {
                        languageIso = if (it) Language.English.iso
                        else Language.Arabic.iso
                        localization.applyLanguage(languageIso)
                    }
                )
            }
        }
    }
}
@Composable
fun MainScreen(
    language: Language,
    onLanguageChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${stringResource(Res.string.mark_as_favorite)}: ${language.name}",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Switch(
            checked = language == Language.English,
            onCheckedChange = onLanguageChange
        )
    }
}