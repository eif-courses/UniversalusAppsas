package eif.viko.lt.mg.universalusappsas.presentation.ui.firebaseAuth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FirebaseAuthenticationScreen(
        authViewModel: FirebaseAuthenticationViewModel = hiltViewModel(),
        navigateToProfileScreen: () -> Unit
    ) {
        LaunchedEffect(Unit) {
            if(authViewModel.isUserAuthenticated) {
                navigateToProfileScreen()
            }
        }
        if (!authViewModel.isUserAuthenticated) {
            //authViewModel.signInAnonymously()
            println("PRISIJUNGE SEKMINGAI: "+authViewModel.isUserAuthenticated)
        }

    }
