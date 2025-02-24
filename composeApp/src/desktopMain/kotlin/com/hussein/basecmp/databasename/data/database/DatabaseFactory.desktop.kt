package com.hussein.basecmp.databasename.data.database

import androidx.room.RoomDatabase
import androidx.room.Room
import java.io.File

//You can change database name
actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "AppName")
            os.contains("mac") -> File(userHome, "Library/Application Support/AppName")
            else -> File(userHome, ".local/share/AppName")
        }

        if(!appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, FavoriteBookDatabase.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}