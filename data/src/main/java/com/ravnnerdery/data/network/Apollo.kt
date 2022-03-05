package com.ravnnerdery.data.network

import com.apollographql.apollo3.ApolloClient
import javax.inject.Inject

interface ApolloClientProvider {
    fun apolloClientInstance(): ApolloClient
}
class ApolloClientProviderImpl @Inject constructor(): ApolloClientProvider {
    override fun apolloClientInstance(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .build()
    }
}