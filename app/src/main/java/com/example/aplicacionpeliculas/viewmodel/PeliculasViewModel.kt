package com.example.aplicacionpeliculas.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aplicacionpeliculas.model.Pelicula

/**
 * hereda de ViewModel y asi si gira la pantalla no se pierden los datos
 */
class PeliculasViewModel : ViewModel() {

    val peliculas: List<Pelicula> = listOf(
        Pelicula(
            id = 1,
            titulo = "The Mandalorian & Grogu",
            tituloOriginal = "The Mandalorian and Grogu",
            anio = 2026,
            pais = "Estados Unidos",
            duracion = "? minutos",
            genero = "Acción, aventuras, ciencia-ficción",
            estrenoEspania = "21 de mayo de 2026",
            estrenoUSA = "22 de mayo de 2026",
            director = "Jon Favreau",
            reparto = "Pedro Pascal, Sigourney Weaver, Jonny Coyne",
            sinopsis = "Din Djarin y Grogu regresan a la gran pantalla en una nueva aventura épica.",
            urlPoster = "https://lumiere-a.akamaihd.net/v1/images/poster_the_mandalorian_and_grogu_6d9a2947.jpeg?region=0,0,743,1100",
            urlTrailer = "https://youtu.be/uwild1rw7Aw?si=5HPyGtLjEZR2Stb4"
        ),
        Pelicula(
            id = 2,
            titulo = "Misión Imposible: El ajuste final",
            tituloOriginal = "Mission: Impossible – The Final Reckoning",
            anio = 2026,
            pais = "Estados Unidos",
            duracion = "169 minutos",
            genero = "Acción, espionaje, thriller",
            estrenoEspania = "21 de mayo de 2026",
            estrenoUSA = "23 de mayo de 2026",
            director = "Christopher McQuarrie",
            reparto = "Tom Cruise, Hayley Atwell, Ving Rhames",
            sinopsis = "Ethan Hunt afronta su misión más peligrosa contra una IA fuera de control.",
            urlPoster = "https://www.reddit.com/media?url=https%3A%2F%2Fpreview.redd.it%2Fnew-final-reckoning-poster-v0-99llptunx1ge1.jpeg%3Fwidth%3D1080%26crop%3Dsmart%26auto%3Dwebp%26s%3D3d77a7a668cc66e22e683e2ef74422f4f8eea8e3",
            urlTrailer = "https://youtu.be/WPcB2J7j6L8?si=OoiXJqa_EByzOMyx"
        ),
        Pelicula(
            id = 3,
            titulo = "Jurassic World: El renacimiento",
            tituloOriginal = "Jurassic World Rebirth",
            anio = 2025,
            pais = "Estados Unidos",
            duracion = "119 minutos",
            genero = "Aventuras, ciencia-ficción, acción",
            estrenoEspania = "2 de julio de 2025",
            estrenoUSA = "2 de julio de 2025",
            director = "Gareth Edwards",
            reparto = "Scarlett Johansson, Jonathan Bailey, Mahershala Ali",
            sinopsis = "Una expedición secreta busca dinosaurios en una isla olvidada.",
            urlPoster = "https://www.imdb.com/es-es/title/tt31036941/mediaviewer/rm797293058/?ref_=ttmi_mi_10_3",
            urlTrailer = "https://youtu.be/1R3LTANp7hw?si=QfKoCY-y3IKnygPU"
        )
    )
    //para recuperar los datos de una pelicula concreta
    fun obtenerPeliculaPorId(id: Int) : Pelicula? = peliculas.find {
        it.id == id
    }

}