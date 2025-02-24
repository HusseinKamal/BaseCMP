package com.hussein.basecmp.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.hussein.basecmp.core.data.HttpClientFactory
import com.hussein.basecmp.databasename.data.database.DatabaseFactory
import com.hussein.basecmp.databasename.data.database.FavoriteBookDatabase
import com.hussein.basecmp.databasename.data.network.KtorRemoteBookDataSource
import com.hussein.basecmp.databasename.data.network.RemoteBookDataSource
import com.hussein.basecmp.databasename.data.repository.DefaultBookRepository
import com.hussein.basecmp.databasename.domain.BookRepository
import com.hussein.basecmp.databasename.presentation.screenname.BookListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    // Use single() for the datasource and repository
    single<RemoteBookDataSource> { KtorRemoteBookDataSource(get()) } // <-- Crucial dependency injection!
    single<BookRepository> { DefaultBookRepository(get(), get()) } // <-- Get the DataSource and Database!

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModel{ BookListViewModel(get()) }
   // viewModelOf(::BookDetailViewModel)
   // viewModelOf(::SelectedBookViewModel)
}