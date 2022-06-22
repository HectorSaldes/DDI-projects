import kotlin.math.pow

fun main() {
    println("-------------Ejercicio 1-------------------")
    println("El cubo del rectangulo es: ${cuboRectangulo()}\n")
    println("-------------Ejercicio 2-------------------")
    println("La energía cinética es: ${energiaCinetica()}\n")
    println("-------------Ejercicio 4-------------------")
    clicGoogle()
}

fun clicGoogle() {
    var primerosClics: Double = 20 * 0.80
    var segundosClics: Double = 60 * 0.30
    var tercerosClics: Double = 100 * 0.25
    var preTotal = primerosClics + segundosClics + tercerosClics
    println("Costo clics: $ $preTotal")
    var conIVA = preTotal * 0.16
    println("IVA: $ $conIVA")
    println("Costo clics + IVA: $ ${preTotal + conIVA}")
}

fun energiaCinetica(): Double {
    val masa: Double = 12.0
    val velocidad: Double = 3.0
    return 0.5 * masa * (velocidad.pow(2.0))
}

fun cuboRectangulo(): Double {
    val largo: Double = 15.0
    val ancho: Double = 23.0
    val alto: Double = 12.0
    return largo * ancho * alto
}
