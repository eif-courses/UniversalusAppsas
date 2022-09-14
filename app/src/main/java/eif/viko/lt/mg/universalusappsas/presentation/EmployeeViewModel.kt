package eif.viko.lt.mg.universalusappsas.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel

import eif.viko.lt.mg.universalusappsas.domain.repository.EmployeeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val repository: EmployeeRepository
) : ViewModel(){

    var state by mutableStateOf(EmployeeState())
        private set
    fun loadEmployees(){
        viewModelScope.launch {

            val result = repository.getEmployeeData()
            state = state.copy(
                isLoading = true,
                error = null,
                employee = result.data
            )
        }
    }

}