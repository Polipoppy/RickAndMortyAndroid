package com.example.technicaltest.domain.repository

import com.example.technicaltest.domain.model.Character
import com.example.technicaltest.domain.model.CharacterDetail

interface RickMortyRepository {

    suspend fun getCharacters(): List<Character>

    suspend fun getCharacterById(characterId: Int): CharacterDetail
}