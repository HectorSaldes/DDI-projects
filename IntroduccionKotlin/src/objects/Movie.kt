package objects

class Movie(
    var name: String,
    var duration: Int?,
    var isAvaible: Boolean = true
) {

//    val name: String = "Monsters Inc."
//    val duration: Int = 90
//    val isAvaible: Boolean = false

    fun playMovie(): String { // Any - cualquier tipado
        return if (isAvaible)
            "Reproduciendo la pelicula ${this.name}........ "
        else
            "La pelicula ${this.name} no esta disponible........ "
    }

    fun stopMovie(): Unit {
        println("Pausando pelicula ........ ")
    }
}