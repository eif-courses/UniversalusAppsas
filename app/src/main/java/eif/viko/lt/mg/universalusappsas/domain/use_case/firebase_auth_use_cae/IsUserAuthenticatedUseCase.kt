package eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae

import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseAuthRepository


class IsUserAuthenticatedUseCase(
    private val repository: FirebaseAuthRepository
) {
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}