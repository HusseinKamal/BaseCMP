package com.hussein.basecmp.databasename.presentation.screenname

import com.hussein.basecmp.core.presentation.UiText
import com.hussein.basecmp.databasename.domain.Book

//Changed based on your project
data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)