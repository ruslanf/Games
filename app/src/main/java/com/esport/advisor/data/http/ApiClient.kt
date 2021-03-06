package com.esport.advisor.data.http

import android.content.Context
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ApiClient(
        private val apiURL: String,
        private val appContext: Context
) : ApiClientInterface {

    private val retrofitClient by lazy { createRetrofitClient(apiURL) }
    private val apiClient by lazy { retrofitClient.create(com.esport.advisor.data.http.NewsApiInterface::class.java) }

    private val cacheSize = (10 * 1024 * 1024).toLong()
    private val httpCacheDirectory = File(appContext.cacheDir, "offlineCache")
    private val httpCache = Cache(httpCacheDirectory, cacheSize)

    private fun httpClient(): OkHttpClient =
            OkHttpClient.Builder()
                    .cache(httpCache)
                    .addNetworkInterceptor(cacheInterceptor())
                    .addInterceptor(offlineCacheInterceptor(appContext))
                    .build()

    private fun createRetrofitClient(apiURL: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(apiURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient())
                    .build()

//    override suspend fun getCurrentBBCNews(api: String): NewsModel {
//        return apiClient.currentBBCNews(api).await()
//    }

    private suspend inline fun <T> Call<T>.await(): T = suspendCancellableCoroutine { coroutine ->
        enqueue(object : Callback<T> {

            override fun onFailure(call: Call<T>, t: Throwable) {
                coroutine.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                when (val result = response.body()) {
                    null -> when (val error = response.errorBody()) {
                        null -> coroutine.resumeWithException(RuntimeException("Null"))
                        else -> error.string()
                    }
                    else -> coroutine.resume(result)
                }
            }
        })
        coroutine.invokeOnCancellation { cancel() }
    }
}