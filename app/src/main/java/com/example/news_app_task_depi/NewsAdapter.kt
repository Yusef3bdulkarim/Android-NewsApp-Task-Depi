package com.example.news_app_task_depi

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

import com.example.news_app_task_depi.databinding.ArticleListItemsBinding

class NewsAdapter(val a: Activity, val article: ArrayList<Articles_Models>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding: ArticleListItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        p0: ViewGroup, p1: Int
    ): NewsViewHolder {

        val b = ArticleListItemsBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return NewsViewHolder(b)
    }

    override fun onBindViewHolder(
        p0: NewsViewHolder, p1: Int
    ) {
        p0.binding.articalText.text = article[p1].title
        Glide.with(p0.binding.image.context).load(article[p1].urlToImage)
            .error(R.drawable.baseline_broken_image_24)
            .transition(DrawableTransitionOptions.withCrossFade(1000)).into(p0.binding.image)

        p0.binding.articleContainer.setOnClickListener {
            val url = article[p1].url
            val i = Intent(Intent.ACTION_VIEW, url.toUri())
            a.startActivity(i)
        }

        p0.binding.shareIcon.setOnClickListener {
            ShareCompat.IntentBuilder(a).setType("text/plain")
                .setChooserTitle("Share article with : ").setText(article[p1].url).startChooser()
        }
    }

    override fun getItemCount() = article.size


}