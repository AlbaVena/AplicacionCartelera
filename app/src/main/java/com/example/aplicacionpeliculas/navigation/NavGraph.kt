import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplicacionpeliculas.navigation.Screen
import com.example.aplicacionpeliculas.view.DetalleScreenView
import com.example.aplicacionpeliculas.view.HomeScreenView
import com.example.aplicacionpeliculas.viewmodel.PeliculasViewModel

//esta funcion dibuja pantallas
@Composable
fun NavGraph(viewModel: PeliculasViewModel) {

    val navController = rememberNavController()

    //contenedor de navegacion. necesita un navController y una startDestination
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        /**
         * esta funcion registra cada pantalla y la asocia a una ruta
         * está dentro de NavHost
         */
        composable(route = Screen.Home.route) {
            HomeScreenView(
                viewModel = viewModel,
                alPulsarPelicula = { peliculaId ->
                    navController.navigate(Screen.Detalle.crearRuta(peliculaId))
                }
            )
        }

        composable(
            route = Screen.Detalle.route,
            arguments = listOf(
                navArgument("peliculaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val peliculaId = backStackEntry.arguments?.getInt("peliculaId") ?: 0
            DetalleScreenView(
                viewModel = viewModel,
                peliculaId = peliculaId,
                alVolver = { navController.popBackStack() }
            )
        }
    }
}