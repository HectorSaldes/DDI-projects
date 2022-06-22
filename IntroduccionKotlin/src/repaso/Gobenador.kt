package repaso

class Gobenador(
    nombre: String,
    edad: Int,
    var estado: String
) : Postulante(nombre, edad) {
    override fun aumentarVoto() {
        println("VOTO PARA EL GOBERNADOR: ${nombre}")
        super.aumentarVoto()
    }
}