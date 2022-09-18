package eif.viko.lt.mg.universalusappsas.presentation.ui.futurama
import eif.viko.lt.mg.universalusappsas.domain.model.Futurama

data class FuturamaState (
    val characters: List<Futurama> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)