package com.study.movieapp.di.modules

import com.study.data.api.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val MOVIES_BASE_URL = "https://kinopoiskapiunofficial.tech/"
    private const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"
    private const val HEADER_API_KEY = "X-API-KEY"

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MOVIES_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    private val apiKeyInterceptor = Interceptor { chain ->
        val request: Request =
            chain.request().newBuilder().addHeader(HEADER_API_KEY, API_KEY).build()
        chain.proceed(request)
    }

}
