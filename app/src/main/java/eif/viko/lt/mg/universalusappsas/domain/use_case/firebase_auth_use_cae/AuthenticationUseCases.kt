package eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae

import com.google.api.BackendRule.AuthenticationCase

data class AuthenticationUseCases(
    val getAuthStateUseCase: GetAuthStateUseCase,
    val isUserAuthenticatedUseCase: IsUserAuthenticatedUseCase,
    val signInAnonymouslyUseCase: SignInAnonymouslyUseCase,
    val signOutUseCase: SignOutUseCase
)