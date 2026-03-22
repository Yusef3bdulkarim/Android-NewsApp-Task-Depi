package com.example.news_app_task_depi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.remote.creation.compose.state.log
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.news_app_task_depi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadNews()
        biding.swipper.setOnRefreshListener { loadNews() }

    }

    private fun loadNews() {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        val c = retrofit.create(News_Helper::class.java)
        c.getNews().enqueue(object : Callback<News_Models> {
            override fun onResponse(
                p0: Call<News_Models?>?,
                p1: Response<News_Models?>?
            ) {
                val news = p1?.body()
                val articles = news?.articles!!
                articles.removeAll {
                    it.title == "[Removed}"
                }
                showNews(articles)
                biding.progress.isVisible = false
                biding.swipper.isRefreshing = false
            }

            override fun onFailure(
                p0: Call<News_Models?>?,
                p1: Throwable?
            ) {
                Log.d("trace", "Error:${p1?.message}")
                biding.progress.isVisible = false

            }

        })
    }

    private fun showNews(artical: ArrayList<Articles_Models>) {
        val adapter = NewsAdapter(this, artical)
        biding.newsList.adapter = adapter
    }
}