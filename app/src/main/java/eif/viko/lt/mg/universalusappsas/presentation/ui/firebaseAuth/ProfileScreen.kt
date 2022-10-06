package eif.viko.lt.mg.universalusappsas.presentation.ui.firebaseAuth

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: () -> Unit
) {

    profileViewModel.state.isUserSignedOutState
}