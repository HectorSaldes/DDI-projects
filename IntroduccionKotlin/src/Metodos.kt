import java.util.*

class Metodos {
    fun playMovie(): Unit {
        println("Reproduciendo pelicula ........ ")
    }

    fun stopMovie(): Unit {
        println("Pausando pelicula ........ ")
    }
}


fun main(args: Array<String>) {
    val metodos: Metodos = Metodos()
    metodos.playMovie()
    metodos.stopMovie()
//    Lectura de datos
    print("Ingresa tu nombre: ")
    val nombre: String? = readLine()
    println(nombre)

    val scanner = Scanner(System.`in`)
    print("Introduce tu edad: ")
    val edad: Int? = scanner.nextInt();
    println("Tu edad es: $edad")
}