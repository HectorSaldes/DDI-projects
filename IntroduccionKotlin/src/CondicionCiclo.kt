import kotlin.math.min

fun main(args: Array<String>) {
//    if
    val capitulos = 3
    if (capitulos > 1) {
        println("Una serie")
    } else if (capitulos == 0) {
        println("No hay nada")
    } else {
        println("Una pelicula")
    }

//    when (switch)
    val diaSemana = 5
    when (diaSemana) {
        1 -> println("Lunes")
        /*2 -> println("Martes")
        3 -> println("Miércoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6 -> println("Sábado")
        7 -> println("Domingo")*/
        else -> println("Error")
    }

//    for
    for (i in 0..10) {
        print("$i ")
    }
    println()
    for (i in 0 until 10) { // Tenemos el -1 implicito
        print("$i ")
    }

    println()
    for (i in 0..10 step 2) { // va de dos en dos
        print("$i ")
    }

    println()
//    while
    var minuto = 0
    var duracion = 10
    while (minuto++ <= duracion) {
        print("$minuto ")
    }

    println()
    println()
//    do while
    minuto = 0
    do {
        print("$minuto ")
    } while (minuto++ <= duracion)
}