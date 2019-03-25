package com.bmacedo.myapplication

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.utils.QueryParam
import io.appflate.restmock.utils.RequestMatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GridTest {

    @Rule
    @JvmField
    var mockWebServerRule = MockWebServerRule()

    private lateinit var api: GridApi

    private val mockTeam = Team(
        1,
        "Luciano",
        "Engine",
        listOf(
            Driver(
                "LuciDriver",
                "1"
            )
        )
    )

    @Before
    fun setUp() {
        api = Retrofit.Builder()
            .baseUrl(RESTMockServer.getUrl())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(GridApi::class.java)
    }

    @Test
    fun get_when200_returnSuccess() {
        val mock200Response = """

        """.trimIndent()
        runBlocking {
            RESTMockServer.whenGET(RequestMatchers.isGET())
                .thenReturnString(200, mock200Response)
            val response = api.fetchTeams().await()
            assertNotNull(response)
            assertEquals(response[0], mockTeam)
        }

    }

}