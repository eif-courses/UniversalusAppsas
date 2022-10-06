package eif.viko.lt.mg.universalusappsas.presentation.ui.firebaseAuth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae.AuthenticationUseCases
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseAuthenticationViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases
) : ViewModel() {
    val isUserAuthenticated get() = authenticationUseCases.isUserAuthenticatedUseCase()

    var state by mutableStateOf(FirebaseAuthenticationState())
        private set

    fun signInAnonymously() {
        viewModelScope.launch {
            authenticationUseCases.signInAnonymouslyUseCase().collect {
                state = state.copy(isSignedInState = it)
            }
        }
    }

}