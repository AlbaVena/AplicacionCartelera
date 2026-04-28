package com.example.aplicacionpeliculas.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aplicacionpeliculas.navigation.Screen
import com.example.aplicacionpeliculas.viewmodel.PeliculasViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleScreenView(
    viewModel: PeliculasViewModel,
    peliculaId: Int,
    alVolver: () -> Unit
){
    val pelicula = viewModel.obtenerPeliculaPorId(peliculaId)
    val conexto = LocalContext.current


    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(pelicula?.titulo ?: "Detalle") },
                navigationIcon = {
                    IconButton(onClick = {alVolver() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ){
        innerPadding ->

        if (pelicula == null){
            Text("Pelicula no encontrada")
            return@Scaffold
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            //ficha tecnica
            Text("FICHA TÉCNICA", fontWeight = FontWeight.Bold)
            HorizontalDivider()
            Text("Título original: ${pelicula.tituloOriginal}")
            Text("Año: ${pelicula.anio}")
            Text("País: ${pelicula.pais}")
            Text("Duración: ${pelicula.duracion}")
            Text("Género: ${pelicula.genero}")
            Text("Estreno en España: ${pelicula.estrenoEspania}")
            Text("Estreno en USA: ${pelicula.estrenoUSA}")
            Text("Dirección: ${pelicula.director}")
            Text("Reparto: ${pelicula.reparto}")

            Spacer(modifier = Modifier.height(8.dp))

            Text("SINOPSIS", fontWeight = FontWeight.Bold)
            HorizontalDivider()
            Text(pelicula.sinopsis)

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pelicula.urlTrailer))
                    conexto.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver trailer en YouTube")
            }


        }


    }



}