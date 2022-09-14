package eif.viko.lt.mg.universalusappsas.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.mg.universalusappsas.data.repository.EmployeeRepositoryImpl
import eif.viko.lt.mg.universalusappsas.domain.repository.EmployeeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(employeeRepositoryImpl: EmployeeRepositoryImpl): EmployeeRepository
}