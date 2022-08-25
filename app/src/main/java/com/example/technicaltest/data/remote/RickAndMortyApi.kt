package com.example.technicaltest.data.remote

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.graphql.GetCharactersQuery
import com.example.graphql.GetCharacterQuery
import com.example.technicaltest.common.Constants
import com.example.technicaltest.data.remote.dto.*
import com.example.technicaltest.domain.model.Character
import com.example.technicaltest.domain.model.CharacterDetail
import com.example.technicaltest.domain.model.Episode
import com.example.technicaltest.domain.model.Location

class RickAndMortyApi {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl(Constants.GRAPHQL_URL)
        .build()

    suspend fun getCharacters(): List<Character> {
        val characters: MutableList<Character> = mutableListOf();
        for (page: Int in 1..20) {
            val response = apolloClient.query(GetCharactersQuery(Optional.Present(page))).execute();
            if (response.data != null && response.data!!.characters != null && response.data!!.characters!!.results != null) {
                response.data!!.characters!!.results!!.forEach { character ->
                    val newChar = Character(
                        character!!.id!!.toInt(),
                        character.image!!,
                        character.name!!
                    );
                    characters.add(newChar);
                }
            }
        }
        return characters;
    }

    suspend fun getCharacter(characterId: Int): CharacterDetail {
        val response = apolloClient.query(GetCharacterQuery(characterId.toString())).execute();

        val data = response.data!!.character!!;
        val character = CharacterDetail(
            created = data.created!!,
            episode = mutableListOf<Episode>(),
            gender = data.gender!!,
            id = data.id!!.toInt(),
            image = data.image!!,
            location = Location(
                name = data.location!!.name!!,
            ),
            name = data.name!!,
            origin = Location(
                name = data.origin!!.name!!,
            ),
            species = data.species!!,
            status = data.status!!,
            type = data.type
        )
        data.episode.forEach { item ->
            character.episode.add(Episode(
                air_date = item!!.air_date!!,
                episode = item.episode!!,
                id = item.id!!.toInt(),
                name = item.name!!
            ))
        }
        return character
    }
}