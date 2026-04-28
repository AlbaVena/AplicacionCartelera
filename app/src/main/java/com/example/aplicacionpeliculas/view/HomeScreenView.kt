package com.example.aplicacionpeliculas.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.aplicacionpeliculas.model.Pelicula
import com.example.aplicacionpeliculas.viewmodel.PeliculasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenView( viewModel: PeliculasViewModel, alPulsarPelicula: (Int) -> Unit){

    /**
     * estructura d euna pantalla. tiene:
     * topBar, bottomBar, floatingActionButton y content.
     * innerPadding lo da automaticamente para que el contenido no se tape por la topBar
     */
    Scaffold (
        topBar = { TopAppBar(title = {
            Text("Estrenos en cartelera")}) }
    ){  innerPadding -> LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        items(viewModel.peliculas){ pelicula ->
            TarjetaPelicula(
                pelicula = pelicula,
                alPulsar = {alPulsarPelicula(pelicula.id)}
            )
        }
    } }
}

@Composable
fun TarjetaPelicula(pelicula: Pelicula, alPulsar: () -> Unit){

    val fuenteInteraccion = remember { MutableInteractionSource() }
    val estaPulsada by fuenteInteraccion.collectIsPressedAsState()
    val escala by animateFloatAsState(
        targetValue = if (estaPulsada) 0.95f else 1f,
        label = "escala_tarjeta"
    )

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .scale(escala)
            .clickable(
                interactionSource = fuenteInteraccion,
                indication = null,
                onClick = alPulsar
            )
    ){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ){
            AsyncImage(
                model = pelicula.urlPoster,
                contentDescription = "Poster de ${pelicula.titulo}",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))

            Column (){
                Text(
                    text = pelicula.titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = pelicula.genero,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = pelicula.anio.toString(),
                    style = MaterialTheme.typography.bodySmall
                )
            }



        }
    }

}