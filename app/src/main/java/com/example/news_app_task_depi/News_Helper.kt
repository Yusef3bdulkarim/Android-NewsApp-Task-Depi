package com.example.news_app_task_depi

import retrofit2.Call
import retrofit2.http.GET

interface News_Helper {
    @GET("/v2/top-headlines?country=us&category=general&apiKey=eebc21a39b834c8c8b2965f4f5714e70&pageSize=30")
    fun getNews(): Call<News_Models>
}