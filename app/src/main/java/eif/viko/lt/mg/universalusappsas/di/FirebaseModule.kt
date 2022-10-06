package eif.viko.lt.mg.universalusappsas.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.repository.FirebaseAuthRepositoryImpl
import eif.viko.lt.mg.universalusappsas.data.repository.FirebaseRepositoryImpl
import eif.viko.lt.mg.universalusappsas.data.repository.ProfileRepositoryImpl
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseAuthRepository
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseRepository
import eif.viko.lt.mg.universalusappsas.domain.repository.ProfileRepository
import eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_auth_use_cae.*
import eif.viko.lt.mg.universalusappsas.domain.use_case.firestore_use_case.GetYoutubeVideosUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirestoreInstance(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository(db: FirebaseFirestore): FirebaseRepository{
        return FirebaseRepositoryImpl(db)
    }

    @Provides
    @Singleton
    fun provideYoutubeUseCase(repository: FirebaseRepository): GetYoutubeVideosUseCase{
        return GetYoutubeVideosUseCase(repository)
    }

    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Provides
    fun provideFirebaseAuthRepository(
        auth: FirebaseAuth
    ): FirebaseAuthRepository = FirebaseAuthRepositoryImpl(auth)

    @Provides
    fun provideProfileRepository(
        auth: FirebaseAuth
    ): ProfileRepository = ProfileRepositoryImpl(auth)

    @Provides
    fun provideAuthenticationUseCases(
        authRepo: FirebaseAuthRepository,
        profileRepo: ProfileRepository
    ) = AuthenticationUseCases(
        isUserAuthenticatedUseCase = IsUserAuthenticatedUseCase(authRepo),
        signInAnonymouslyUseCase = SignInAnonymouslyUseCase(authRepo),
        getAuthStateUseCase = GetAuthStateUseCase(authRepo),
        signOutUseCase = SignOutUseCase(profileRepo),

    )




}