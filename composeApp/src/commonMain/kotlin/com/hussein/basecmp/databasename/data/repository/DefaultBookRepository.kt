package com.hussein.basecmp.databasename.data.repository
//Handle calls of APIs and local database

import androidx.sqlite.SQLiteException
import com.hussein.basecmp.core.domain.DataError
import com.hussein.basecmp.core.domain.EmptyResult
import com.hussein.basecmp.databasename.data.database.FavoriteBookDao
import com.hussein.basecmp.databasename.data.network.RemoteBookDataSource
import com.hussein.basecmp.databasename.domain.Book
import com.hussein.basecmp.databasename.domain.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.hussein.basecmp.core.domain.Result
class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
): BookRepository {
    /*override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)

        return if(localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch(e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }*/
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        TODO("Not yet implemented")
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFromFavorites(id: String) {
        TODO("Not yet implemented")
    }
}
