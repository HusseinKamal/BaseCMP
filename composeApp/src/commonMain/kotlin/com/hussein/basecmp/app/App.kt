package com.hussein.basecmp.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hussein.basecmp.databasename.data.local.DataStoreRepository
import com.hussein.basecmp.databasename.data.local.createDataStore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
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
              /*  val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }*/
            }
        }
    }
}