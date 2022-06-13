package com.jonghyun.data.remote.provider

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_SEC: Long = 60
private const val DEF_URL = "https://api.github.com/search/"

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val okHttp = OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS) // connect timeout - default(30 sec)
            readTimeout(TIMEOUT_SEC, TimeUnit.SECONDS) // read timeout - default(30 sec)
            writeTimeout(TIMEOUT_SEC, TimeUnit.SECONDS) // write timeout - default(30 sec)
        }.build()

        return okHttp
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DEF_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}