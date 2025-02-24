package com.hussein.basecmp.di

import com.hussein.basecmp.core.domain.language.Localization
import com.hussein.basecmp.databasename.data.database.DatabaseFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Darwin.create() }
        single { DatabaseFactory() }
        single<Localization> { Localization() }
    }