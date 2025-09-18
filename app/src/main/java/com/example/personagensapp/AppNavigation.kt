import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personagensapp.modelo.Personagem
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            TelaLista(navController)
        }
        composable("detalhe/{personagemJson}") { backStackEntry ->
            val raw = backStackEntry.arguments?.getString("personagemJson")
            val json = raw?.let { Uri.decode(it) }
            val personagem = Gson().fromJson(json, Personagem::class.java)
            TelaDetalhe(navController, personagem)
        }
    }
}
