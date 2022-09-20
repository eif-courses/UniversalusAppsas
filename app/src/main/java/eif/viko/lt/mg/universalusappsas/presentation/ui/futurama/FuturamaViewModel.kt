package eif.viko.lt.mg.universalusappsas.presentation.ui.futurama

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case.GetFuturamaCharactersUseCase
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FuturamaViewModel @Inject constructor(
    private val getFuturamaCharactersUseCase: GetFuturamaCharactersUseCase
) : ViewModel() {

    var state by mutableStateOf(FuturamaState())
        private set

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UIEvent{
        data class ShowSnackbar(val message: String): UIEvent()
    }

    init {
        getCharacters()
    }

    private fun getCharacters(){
        getFuturamaCharactersUseCase().onEach { result ->
            state = when(result){
                is Resource.Success -> {
                    state.copy(
                        characters = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        characters = result.data ?: emptyList(),
                        isLoading = false
                    )
                    //_eventFlow.emit(UIEvent.ShowSnackbar("awe"))
                }
                is Resource.Loading -> {
                    state.copy(
                        characters = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
            }

        }.launchIn(viewModelScope)
    }
}