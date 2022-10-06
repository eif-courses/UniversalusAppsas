package eif.viko.lt.mg.universalusappsas.presentation.ui.firebaseAuth

import eif.viko.lt.mg.universalusappsas.domain.util.Resource

data class FirebaseAuthenticationState(
    val isSignedInState: Resource<Boolean>? = null

)