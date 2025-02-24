package com.hussein.basecmp.databasename.data.network

import com.hussein.basecmp.core.domain.DataError


interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    )//: Result<SearchResponseDto, DataError.Remote>

   // suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}
