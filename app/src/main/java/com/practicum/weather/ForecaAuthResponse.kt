package com.practicum.weather

import com.google.gson.annotations.SerializedName

class ForecaAuthResponse (@SerializedName("access_token") val token: String)
    //класс описывающий ответ с сервера на запрос аутентификации
