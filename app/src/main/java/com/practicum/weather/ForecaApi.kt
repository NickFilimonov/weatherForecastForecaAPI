package com.practicum.weather

import retrofit2.Call
import retrofit2.http.*

//интерфейс где мы прописываем нужные запросы
interface ForecaApi {

    //запрос на прохождение аутентификации, отправляе логин и пароль (объект класса ForecaAuthRequest), в ответ ждем токен
    // прописываем аннотации для retrofit
    @POST("/authorize/token?expire_hours=-1")
    fun authenticate(@Body request: ForecaAuthRequest): Call<ForecaAuthResponse>

    //запрос на поиск городов, передаем токен в ответ ожидаем список городов
    @GET("/api/v1/location/search/{query}")
    fun getLocations(@Header("Authorization") token: String, @Path("query") query: String): Call<LocationsResponse>

    //запрос на получения погоды в выбранном городе
    @GET("/api/v1/current/{location}")
    fun getForecast(@Header("Authorization") token: String, @Path("location") locationId: Int): Call<ForecastResponse>
}

