package eif.viko.lt.mg.universalusappsas.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.EmployeeApi
import eif.viko.lt.mg.universalusappsas.data.repository.EmployeeRepositoryImpl
import eif.viko.lt.mg.universalusappsas.domain.repository.EmployeeRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesEmployeeApi(): EmployeeApi {
        return Retrofit.Builder()
            .baseUrl(EmployeeApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }
    @Provides
    @Singleton
    fun provideEmployeeRepository(api: EmployeeApi): EmployeeRepository{
        return EmployeeRepositoryImpl(api)
    }
}