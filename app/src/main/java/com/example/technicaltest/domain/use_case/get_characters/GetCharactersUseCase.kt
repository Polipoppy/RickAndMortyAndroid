package com.example.technicaltest.domain.use_case.get_characters

import com.example.technicaltest.common.Resource
import com.example.technicaltest.domain.model.Character
import com.example.technicaltest.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val characters = repository.getCharacters()
            emit(Resource.Success<List<Character>>(characters))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Character>>("Couldn't react server. Check your internet connection"))
        }
    }
}