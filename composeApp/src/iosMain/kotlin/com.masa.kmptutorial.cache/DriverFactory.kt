package com.masa.kmptutorial.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.masa.kmpplayground.entity.cache.AppDatabase

actual class DriverFactory() {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "items.db")
    }

}