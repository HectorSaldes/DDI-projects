package repaso

class Presidente(
    nombre: String,
    edad: Int,
) : Postulante(nombre, edad) {

    override fun aumentarVoto() {
        println("VOTO PARA EL PRESIDENTE: ${nombre}")
        super.aumentarVoto()
    }
}