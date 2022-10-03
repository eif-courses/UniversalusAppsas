package eif.viko.lt.mg.universalusappsas.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.repository.FirebaseRepositoryImpl
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseRepository
import eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_use_case.GetYoutubeVideosUseCase
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
    fun provideFirebaseRepository(database: FirebaseFirestore): FirebaseRepository{
        return FirebaseRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideGetYoutubeUseCase(repository: FirebaseRepository): GetYoutubeVideosUseCase {
        return GetYoutubeVideosUseCase(repository)
    }


}