package com.example.aplicacionpeliculas.navigation

sealed class Screen(val route : String){
    object Home : Screen("home")

    //se forma la ruta completa como en el ejemplo de crearRuta
    object Detalle : Screen("detalle/{peliculaId}"){
        fun crearRuta(peliculaId : Int) : String = "detalle/$peliculaId"
    }
}