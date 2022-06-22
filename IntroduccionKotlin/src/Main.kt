fun main(args: Array<String>) {
    val esHombre: Boolean = true // Constante
    var nombre: String = "Hector" // Variables
    var edad: Int = 23
    var altura: Double = 1.75
    var peso: Float = 82.5f
    var dinero: Long = 78787857575513
    var dineroSinEspecificar = 18897L


    val list = mutableListOf<Any>("Hola", 54, 5858.3434, false)



    // Buscar porque intelliJ ilumina más el Long

    var nombreNovia = "Laddy Di"
    var caracteresNovia = nombreNovia.length // Conocer el tamaño de la cadena
    var validacion = nombreNovia.isEmpty()
    var contiene = nombreNovia.contains("Lady")
    var rango = nombreNovia.substring(0, 4)
    var remplazar = nombreNovia.replace("Laddy", "Lady")

    println("Hola mundo") // Impresión en pantalla
    println("Hola mundo ${args.contentToString()} y mi género es: ${if (esHombre) "Hombre" else "Mujer"} ") // Template string
    println("The boss is $nombre")


    val numero = 14.948
    println("${String.format("El valor completo es: %.3f", numero)}")
    /* %b = boolean,
       %c = char,
       %d = int,
       %.nf = double o float -> donde n es número de decimales,
       %s = string
     */
}