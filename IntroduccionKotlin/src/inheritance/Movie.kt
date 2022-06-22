package inheritance

// Son

// Tenemos que volver a solicitarlos

// A estos atributos no se le colocan var para crear objetos en memoría sino temporales para que mueran luego luego
class Movie(
    name: String,
    duration: Int,
    isAvailable: Boolean,
) : Media(name, duration, isAvailable) {

    //    Polimorfismo
    override fun play(): String {
        return if (this.isAvailable)
            "Reproduciendo la pelicula ${this.name} con duración ${this.duration}"
        else "No se encuentra disponible ${this.name}"
    }


}