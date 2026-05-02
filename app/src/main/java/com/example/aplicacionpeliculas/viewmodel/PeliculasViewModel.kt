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
            urlPoster = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgVFrFGl3T6iZSUFdefGYmvHcEt19wyJRrmAqm47JaBm0KzUlo9eDPu86AhHLDtD0mNSBgsBCr-QQlcmlbh8GFC_Jx-nSRMhuegs-ODF4NNhlZxptVKIp8vNc5AhQDKTpGO-6ZgBVSslQh2lM_NOBFyneqx7BIVxUuwcnW9vrZZ3rVX3EspcM3_83D3NIg/s1004/critica-mision-imposible-sentencia-final.jpg",
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
            urlPoster = "https://m.media-amazon.com/images/M/MV5BNjg2NTcwYWQtYzk4NS00MTJhLWEzZjItMzIxNjk3YzlkYzU0XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
            urlTrailer = "https://youtu.be/1R3LTANp7hw?si=QfKoCY-y3IKnygPU"
        )
    )
    //para recuperar los datos de una pelicula concreta
    fun obtenerPeliculaPorId(id: Int) : Pelicula? = peliculas.find {
        it.id == id
    }

}