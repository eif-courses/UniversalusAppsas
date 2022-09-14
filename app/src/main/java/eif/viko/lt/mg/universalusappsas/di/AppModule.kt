package eif.viko.lt.mg.universalusappsas.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesEmployeeApi(): EmployeeApi{
        return Retrofit.Builder()
            .baseUrl("https://saltoniskes.firebaseio.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }
}