package com.hussein.basecmp.databasename.presentation.screenname

import com.hussein.basecmp.databasename.domain.Book

//Changed based on your project
sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}