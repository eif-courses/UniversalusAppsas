package eif.viko.lt.mg.universalusappsas.presentation.ui.firebaseAuth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae.AuthenticationUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authenticationUseCases: AuthenticationUseCases
) : ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

    fun signOut(){
        viewModelScope.launch {
            authenticationUseCases.signOutUseCase().collect{
                state = state.copy(isUserSignedOutState = it)
            }
        }
    }
}