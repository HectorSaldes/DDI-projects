package inheritance

// Daddy

// open para que pueda heredar
open class Media(
    var name: String,
    var duration: Int,
    var isAvailable: Boolean,
    var chapters: Int = 0
) {

    /*
        LAS CONSTANTES DE CONSTANTES: companion object
        NO se crean instancias
    */

    companion object {

        private const val FAME_RATE_HD = 68;
        private const val FAME_RATE_SD = 24

        private const val SECONDS_IN_A_MINUTE = 60

        public const val NAME:String = "name"

        fun getTotalFrames(duration: Int, isHD: Boolean): Int {
            return if (isHD) FAME_RATE_HD * SECONDS_IN_A_MINUTE * duration
            else FAME_RATE_SD * SECONDS_IN_A_MINUTE * duration
        }
    }


    //    permitir sobreescritura con open para abrir el método
    open fun play(): String {
        return if (this.isAvailable)
            "Reproduciendo la ${if (this.chapters > 0) "serie" else "pelicula"} ${this.name} con duración ${if (this.chapters > 0) this.chapters * this.duration else this.duration}"
        else "No se encuentra disponible ${this.name}"
    }

    open fun stop(): String {
        return "Pausando la película ${this.name}"
    }
}