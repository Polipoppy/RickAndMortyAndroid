package com.example.technicaltest.data.repository

import com.example.technicaltest.data.remote.RickAndMortyApi
import com.example.technicaltest.domain.model.Character
import com.example.technicaltest.domain.model.CharacterDetail
import com.example.technicaltest.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : RickMortyRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters()
    }

    override suspend fun getCharacterById(characterId: Int): CharacterDetail {
        return api.getCharacter(characterId)
    }

}