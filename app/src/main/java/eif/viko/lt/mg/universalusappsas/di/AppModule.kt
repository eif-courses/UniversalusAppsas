package eif.viko.lt.mg.universalusappsas.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.FuturamaApi
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
    fun provideFuturamaRepository(api: FuturamaApi): FuturamaRepository{
        return FuturamaRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFuturamaUseCases(repository: FuturamaRepository): FuturamaUseCases{
        return FuturamaUseCases(
            getFuturamaCharactersUseCase = GetFuturamaCharactersUseCase(repository)
        )
    }

}