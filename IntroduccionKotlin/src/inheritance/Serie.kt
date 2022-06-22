package inheritance

class Serie(

    name: String,
    duration: Int,
    isAvailable: Boolean,
    chapters: Int

) : Media(name, duration, isAvailable, chapters) {

//    Polimorfismo
    override fun play(): String {
        return if (this.isAvailable)
            "Reproduciendo la serie ${this.name} con ${this.chapters} capítulos y duración de ${this.duration * this.chapters} minutos"
        else "No se encuentra disponible la serie ${this.name}"
    }

}