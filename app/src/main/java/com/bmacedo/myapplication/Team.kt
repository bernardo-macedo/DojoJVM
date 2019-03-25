package com.bmacedo.myapplication

import java.io.Serializable

data class Team (
    val id: Int,
    val name: String,
    val engine: String,
    val drivers: List<Driver> = emptyList()
) : Serializable
