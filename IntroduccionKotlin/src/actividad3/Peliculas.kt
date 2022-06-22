package actividad3

import java.util.*

fun main(args: Array<String>) {
    val peliculas: Array<String> =
        arrayOf(
            "sdf4sd65f",
            "Toy Storysdfsdfs sfsdhfsjdahfsdhfheiwouriwurpquworiwoeirpowqierweir",
            "Pulp Fiction",
            "Batman: El Caballero de la noche",
            "Kil bill",
            "Spiritafsdfdjgkhsdjfghjkhowerotiueritueroituoierutioeruwtio"
        )
//    checkLength(peliculas)
    checkLengthStram(peliculas)
}


fun checkLengthStram(array: Array<String>) {
    Arrays.sort(array)
    println(array.contentToString())
}

fun checkLength(array: Array<String>) {
    var max: String = array[0]
    var pos = 0
    for (i in 1 until array.size) {
        if (array[i].length > max.length ) {
            max = array[i]
            pos = i
        }
    }
    println("El título más largo fue: $max \nEn la poscición: $pos")
}