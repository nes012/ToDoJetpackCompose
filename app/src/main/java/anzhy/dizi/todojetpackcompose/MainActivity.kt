package anzhy.dizi.todojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import anzhy.dizi.todojetpackcompose.navigation.SetupNavigation
import anzhy.dizi.todojetpackcompose.ui.theme.ToDoJetpackComposeTheme
import anzhy.dizi.todojetpackcompose.ui.viewmodels.SharedViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoJetpackComposeTheme {
                //navController = rememberNavController()
                navController = rememberAnimatedNavController()

                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
