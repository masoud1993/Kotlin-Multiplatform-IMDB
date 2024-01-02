package com.masa.kmptutorial.cache

import entity.MoviesResult
import org.masa.kmpplayground.entity.cache.AppDatabase

class Database(databaseDriverFactory: DriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun insertVideo(video : MoviesResult.Result){
        dbQuery.insertVideo(video.Title, video.Year, video.imdbID, video.Type, video.Poster)
    }

    internal fun removeAllVideos(){
        dbQuery.transaction {
            dbQuery.removeAllVideos()
        }
    }

    internal fun getAllVideos(): List<MoviesResult.Result>{
        return dbQuery.selectAllVideos(::mapVideos).executeAsList()
    }

    private fun mapVideos(
        title: String?,
        year: String?,
        imdbId: String?,
        type: String?,
        poster: String?
    ): MoviesResult.Result {
        return MoviesResult.Result(
            poster ?: "",
            title ?: "",
            type ?: "",
            year ?: "",
            imdbId ?: ""
        )
    }

    internal fun insertVideos(videos: List<MoviesResult.Result>) {
        dbQuery.transaction {
            videos.forEach { video ->
                insertVideo(video)
            }
        }
    }
}