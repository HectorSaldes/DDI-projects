fun main(args: Array<String>) {
    val arregloEnteros: IntArray = intArrayOf(1, 2, 3)
    println(arregloEnteros.contentToString())

    val arregloBoleanos: BooleanArray = booleanArrayOf(false, true, false, true)

    val arregloCadena = arrayOf("Hector", "Saldaña", "Espinoza")

    for (cadena in arregloCadena)
        println(cadena)

    val factorial: IntArray = intArrayOf(1, 2, 3, 4, 5)
    var totalFactorial = 1
    for (elemento in factorial)
        totalFactorial *= elemento;
    println("Total del factorial de 5 es: $totalFactorial")
}