package com.bmacedo.myapplication

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface GridApi {

    @GET("teams")
    fun fetchTeams(): Deferred<List<Team>>

}
