package com.aman.paging3compose.api

import com.aman.paging3compose.utils.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:ApiHelper by lazy {
        retrofit.create(ApiHelper::class.java)
    }

}