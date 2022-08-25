package com.example.technicaltest.domain.use_case.get_character

import com.example.technicaltest.common.Resource
import com.example.technicaltest.domain.model.CharacterDetail
import com.example.technicaltest.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    operator fun invoke(characterId: Int): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading<CharacterDetail>())
            val character = repository.getCharacterById(characterId)
            emit(Resource.Success<CharacterDetail>(character))
        } catch (e: HttpException) {
            emit(Resource.Error<CharacterDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CharacterDetail>("Couldn't react server. Check your internet connection"))
        }
    }
}