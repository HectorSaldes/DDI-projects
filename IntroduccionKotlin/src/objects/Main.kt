package objects

fun main(args: Array<String>) {
    val movie: Movie = Movie("Avengers",230 )
    println(movie.duration)
    println(movie.playMovie())
}