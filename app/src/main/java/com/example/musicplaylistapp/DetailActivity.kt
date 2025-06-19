package com.example.musicplaylistapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val listView = findViewById<ListView>(R.id.songlist)
        val averageRatingText = findViewById<TextView>(R.id.averageRatingtext)
        val btnCalculateAverage = findViewById<Button>(R.id.averageRating)
        val btnReturn = findViewById<Button>(R.id.retunbutton)

        val minSize = listOf(titles.size, artists.size, ratings.size, comments.size).minOrNull() ?: 0

        val songsList = (0 until minSize).map { index ->
            "${titles[index]} by ${artists[index]} (Rating: ${ratings[index]}, Comment: ${comments[index]})"
        }

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsList)

        btnCalculateAverage.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val average = ratings.sum().toDouble() / ratings.size
                averageRatingText.text = "Average Rating: %.2f".format(average)
            } else {
                averageRatingText.text = "No ratings yet."
            }
        }

        btnReturn.setOnClickListener { finish() }
    }
}