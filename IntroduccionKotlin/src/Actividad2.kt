import java.util.Scanner

/*
* Saldaña Espinoza Hector
* 9B
* Desarrollo para dispositivos inteligentes
* */

class Validaciones {
    private val scanner: Scanner = Scanner(System.`in`);
    private var clicks: Int = 0

    fun welcome() {
        println("\t--- GOOGLE ADS ---")
    }

    fun validNumber() {
        var flag = false
        do {
            try {
                print("Ingresé la cantidad de clics: ")
                clicks = scanner.nextInt()
                flag = (clicks > 0)
            } catch (ex: Exception) {
                println("\t ENTRADA INVÁLIDA")
                scanner.next()
            }
        } while (!flag)
    }

    fun calculate() {
        var money: Double = 0.0
        var iva: Double = 0.0
        var total: Double = 0.0
        var firstClicks: Double = 0.0
        var secondClicks: Double = 0.0
        var thirdClicks: Double = 0.0
        when (clicks) {
            in 1..20 -> firstClicks = clicks * 0.80
            in 21..80 -> {
                firstClicks = 20 * 0.80
                clicks -= 20
                secondClicks = clicks * 0.30
            }
            else -> {
                firstClicks = 20 * 0.80
                secondClicks = 60 * 0.30
                clicks -= 80
                thirdClicks = clicks * 0.25
            }
        }
        money = firstClicks + secondClicks + thirdClicks
        iva = 0.16 * money
        total = money + iva
        println("\n\t    RESUMEN    ")
        println("Costo (sin IVA): $ $money")
        println("IVA: $ $iva")
        println("Total: $ $total")
    }
}

fun main(args: Array<String>) {
    val validaciones: Validaciones = Validaciones()
    validaciones.welcome();
    validaciones.validNumber()
    validaciones.calculate();
    clock()
}

fun clock() {
    var h = 0
    var m = 0
    var s = 0
    println("\n\t--- RELOJ ---")
    val hours: IntArray = IntArray(24)
    val minutes: IntArray = IntArray(60)
    val seconds: IntArray = IntArray(60)
    for (h in 0..hours.size) {
        for (m in 0..minutes.size) {
            for (s in 0..seconds.size) {
                println("${if (h < 10) "0" else ""}$h : ${if (m < 10) "0" else ""}$m : ${if (s < 10) "0" else ""}$s")
                Thread.sleep(1000)
            }
        }
    }
}