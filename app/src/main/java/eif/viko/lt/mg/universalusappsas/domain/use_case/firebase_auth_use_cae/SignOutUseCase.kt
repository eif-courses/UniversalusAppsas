package eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae

import eif.viko.lt.mg.universalusappsas.domain.repository.ProfileRepository

class SignOutUseCase(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke() = repository.signOut()
}