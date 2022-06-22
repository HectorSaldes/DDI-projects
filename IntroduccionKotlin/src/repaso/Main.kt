package repaso

fun main(args:Array<String>){

    val hector: Presidente = Presidente("Hector Saldaña", 21)
    hector.aumentarVoto()
    hector.aumentarVoto()
    hector.aumentarVoto()
    hector.aumentarVoto()

    val jair: Gobenador = Gobenador("Jair Vasquez", 22, "Temixco")
    jair.aumentarVoto()
    jair.aumentarVoto()
    jair.aumentarVoto()
    jair.aumentarVoto()
    jair.aumentarVoto()
    jair.aumentarVoto()


    hector.mostrarVotos()
    jair.mostrarVotos()



}