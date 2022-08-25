package com.example.technicaltest.presentation.character_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltest.common.Constants
import com.example.technicaltest.common.Resource
import com.example.technicaltest.domain.use_case.get_character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getCharacter(characterId.toInt())
        }
    }

    private fun getCharacter(characterId: Int) {
        getCharacterUseCase(characterId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailState(character = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}