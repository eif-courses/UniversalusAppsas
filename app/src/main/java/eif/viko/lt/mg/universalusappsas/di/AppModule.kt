package eif.viko.lt.mg.universalusappsas.di

import android.app.Application
import android.provider.DocumentsContract.Root
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.local.FuturamaDao
import eif.viko.lt.mg.universalusappsas.data.local.FuturamaDatabase
import eif.viko.lt.mg.universalusappsas.data.remote.FuturamaApi
import eif.viko.lt.mg.universalusappsas.data.repository.FuturamaRepositoryImpl
import eif.viko.lt.mg.universalusappsas.domain.repository.FuturamaRepository

import eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case.FuturamaUseCases
import eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case.GetFuturamaCharactersUseCase
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFuturamaApi(): FuturamaApi {
        return Retrofit.Builder()
            .baseUrl(FuturamaApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(FuturamaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFuturamaRepository(
        api: FuturamaApi,
        db: FuturamaDatabase
    ): FuturamaRepository {
        return FuturamaRepositoryImpl(api, db.dao)
    }
    @Provides
    @Singleton
    fun provideCharactersDatabase(app: Application): FuturamaDatabase{
        return Room.databaseBuilder(
            app,
            FuturamaDatabase::class.java,
            "characters_db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideFuturamaUseCases(repository: FuturamaRepository): FuturamaUseCases {
        return FuturamaUseCases(
            getFuturamaCharactersUseCase = GetFuturamaCharactersUseCase(repository)
        )
    }
}