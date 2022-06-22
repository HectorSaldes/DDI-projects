package repaso

open class Postulante(
    var nombre: String,
    var edad: Int,
    var votos: Int = 0
) {

    open fun aumentarVoto(): Unit {
        this.votos++
    }

    fun mostrarVotos():Unit{
        println("$votos VOTOS DE $nombre")
    }
}