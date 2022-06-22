package inheritance


fun main(args: Array<String>) {

    val spiderman = Movie(Media.NAME, 90, true)
    val pelusaCaligari = Serie("Pelisa", 30, true, 25);

    println(spiderman.play())
    println(pelusaCaligari.play())

    println(Media.getTotalFrames(spiderman.duration, true))
}