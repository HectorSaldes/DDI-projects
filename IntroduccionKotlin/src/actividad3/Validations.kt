package actividad3

import java.util.Scanner

class Validations {

    private val scanner: Scanner = Scanner(System.`in`);
    private var num: Int = 0

    fun validNumber(sms: String) {
        var flag = false
        do {
            try {
                print(sms)
                num = scanner.nextInt()
                flag = (num > 0)
            } catch (ex: Exception) {
                println("\t ENTRADA INVÁLIDA")
                scanner.next()
            }
        } while (!flag)
    }


    fun checkNumberMiligrames() {
        if (num > 100) println("¡Felicidades, es una buena opción multijugos!")
        else println("La poción es mediocre, sangre sucia inmunda")
    }

    fun countNumbers() {
        var total: Int = 0
        for (i in 1..num)
            total += i;
        println("La suma es: $total")
    }

    fun checkWeather() {
        when (num) {
            1 -> println("Soleado")
            2 -> println("Nublado")
            3 -> println("Lluvioso")
            4 -> println("Tormentoso")
            5 -> println("Nevado")
            in 6..9 -> println("Rangos")
            else -> println("Preguntale a Google")
        }
    }

    fun getPairs() {
        for (i in 1..num) {
            if (i % 2 == 0) print("$i ")
        }
    }
}