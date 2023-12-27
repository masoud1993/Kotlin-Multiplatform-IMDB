package com.masa.kmptutorial.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.masa.kmpplayground.entity.cache.AppDatabase

actual class DriverFactory() {
    actual fun createDriver(): SqlDriver {
        val url = "jdbc:sqlite:src/desktopMain/items.db"
        val driver: SqlDriver = JdbcSqliteDriver(url)
        AppDatabase.Schema.create(driver)
        return driver
    }

}