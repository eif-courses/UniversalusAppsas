package eif.viko.lt.mg.universalusappsas.presentation.ui.futurama

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case.GetFuturamaCharactersUseCase
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FuturamaViewModel @Inject constructor(
    private val getFuturamaCharactersUseCase: GetFuturamaCharactersUseCase
) : ViewModel() {

    var state by mutableStateOf(FuturamaState())
        private set

    init {
        getCharacters()
    }

    private fun getCharacters(){
        getFuturamaCharactersUseCase().onEach { result ->
            state = when(result){
                is Resource.Success -> {
                    state.copy(characters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state.copy(error = result.message ?: "An unexpected error occurred!")
                }
            }

        }.launchIn(viewModelScope)
    }
}