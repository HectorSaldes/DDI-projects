package actividad3

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner: Scanner = Scanner(System.`in`);
    var distancia: Double = 0.0
    var temp: String? = ""
    var disponible: Boolean = false
    var repetir = false;
    do {
        println("\n\t SERVICIO DE UBER")
        print("Dime la distancia: ")
        distancia = scanner.nextDouble();
        print("Estás disponible? (Sí = Escribe, No = Enter): ")
        temp = readLine()
        disponible = temp?.isNotEmpty() ?: false
        if (distancia in 0.1..0.5) {
            if (disponible) {
                println("Listo para iniciar el recorrido")
            } else {
                println("Conductor cercano, pero no disponible")
            }
        } else if (distancia > 0.5) {
            if (disponible) {
                println("Conductor disponible pero muy lejos, aplicará tarifas más altas")
            } else {
                println("No hay conductores disponibles")
            }
        } else {
            print("Deseas buscar de nuevo? (Sí = Escribe, No = Enter): ")
            temp = readLine()
            repetir = temp?.isNotEmpty() ?: false
        }
    } while (repetir)
}