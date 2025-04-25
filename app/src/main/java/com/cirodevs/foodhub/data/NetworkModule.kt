package com.cirodevs.foodhub.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun ProvideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://127.0.0.1:8080/") // verificar el puerto en la base y back
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideFoodApi(retrofit: Retrofit) : FoodApi {
        return retrofit.create(FoodApi::class.java)

    }
}