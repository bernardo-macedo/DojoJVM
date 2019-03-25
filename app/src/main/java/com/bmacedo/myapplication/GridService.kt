package com.bmacedo.myapplication

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GridService {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://formula1.getsandbox.com").addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()


}