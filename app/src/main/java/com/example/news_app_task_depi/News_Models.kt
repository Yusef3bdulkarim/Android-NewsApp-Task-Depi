package com.example.news_app_task_depi

data class News_Models(
    val articles: ArrayList<Articles_Models>
)


data class Articles_Models(
    val title: String,
    val url: String,
    val urlToImage: String,

    )


//"status": "ok",
//"totalResults": 35,
//"articles": [

//{
//    "source": {
//    "id": null,
//    "name": "CBS Sports"
//},
//    "author": null,
//    "title": "Hofstra Pride vs. Alabama Crimson Tide Live Score and Stats - March 20, 2026 Gametracker - CBS Sports",
//    "description": "Get real-time Men's College Basketball coverage and scores as Hofstra Pride takes on Alabama Crimson Tide. We bring you the latest game previews, live stats, expert picks and recaps on CBS Sports",
//    "url": "https://www.cbssports.com/college-basketball/gametracker/recap/NCAAB_20260320_HOFSTRA@BAMA/",
//    "urlToImage": "https://sportsfly.cbsistatic.com/fly-504/bundles/sportsmediacss/images/fantasy/default-article-image-large.png",
//    "publishedAt": "2026-03-20T23:57:28Z",
//    "content": "TAMPA, Fla. (AP) Labaron Philon Jr. finished with 29 points, eight rebounds and seven assists, and No. 4 seed Alabama Crimson Tide rallied from an early double-digit deficit to beat 13th-seeded Hofst… [+3299 chars]"
//},