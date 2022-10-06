package eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae

import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseAuthRepository

class GetAuthStateUseCase(
    private val repository: FirebaseAuthRepository
) {
}