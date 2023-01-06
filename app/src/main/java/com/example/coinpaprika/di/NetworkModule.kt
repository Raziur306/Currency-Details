package com.example.coinpaprika.di

import com.example.coinpaprika.common.Constants.BASE_URL
import com.example.coinpaprika.data.remote.Api
import com.example.coinpaprika.data.repository.CoinRepositoryImp
import com.example.coinpaprika.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providePaprikaApi(): Api {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: Api): CoinRepository {
        return CoinRepositoryImp(api)
    }
}