package com.hussein.basecmp.databasename.data.database

import androidx.room.RoomDatabaseConstructor

//You can change database name
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseConstructor: RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase
}