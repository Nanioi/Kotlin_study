package com.example.myapplication

import java.io.Serializable

class Youtube(
    var title: String? = null,
    val content: String? = null,
    val thumbnail: String? = null,
    val video: String? = null
) : Serializable