package entity

data class MoviesResult(
    val result: List<Result>,
    val success: Boolean
){

    data class Result(
        val Poster: String,
        val Title: String,
        val Type: String,
        val Year: String,
        val imdbID: String
    )

}