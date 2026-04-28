package com.example.aplicacionpeliculas.model

data class Pelicula(
    val id: Int,
    val titulo : String,
    val tituloOriginal : String,
    val anio: Int,
    val pais : String,
    val duracion : String,
    val genero: String,
    val estrenoEspania: String,
    val estrenoUSA: String,
    val director: String,
    val reparto: String,
    val sinopsis: String,
    val urlPoster: String,
    val urlTrailer: String
)
