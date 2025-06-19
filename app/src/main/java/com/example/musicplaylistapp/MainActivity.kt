package com.example.musicplaylistapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val songTitles = ArrayList<String>()
    private val artists = ArrayList<String>()
    private val ratings = ArrayList<Int>()
    private val comments = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnAdd = findViewById<Button>(R.id.playlist)
        val btnView = findViewById<Button>(R.id.browse)
        val btnExit = findViewById<Button>(R.id.exit)
        val textView = findViewById<TextView>(R.id.welcome)

        // 1st BUTTON - Add to Playlist
        btnAdd.setOnClickListener {
            addSongToPlaylist()
        }

        // 2nd BUTTON - Navigate to Second Screen
        btnView.setOnClickListener { // Corrected: Using btnView as declared above
            val intent = Intent(this, DetailActivity::class.java)
            intent.putStringArrayListExtra("titles", songTitles)
            intent.putStringArrayListExtra("artists", artists)
            intent.putIntegerArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)
            startActivity(intent)
        }

        // 3rd BUTTON - Exit App
        btnExit.setOnClickListener {
            finish()
        }
    }

    private fun addSongToPlaylist() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val titleInput = EditText(this).apply { hint = "Track Title" }
        val artistInput = EditText(this).apply { hint = "Artist Name" }
        val ratingInput = EditText(this).apply { hint = "Rating (1-5)"
            inputType = android.text.InputType.TYPE_CLASS_NUMBER
        }
        val commentInput = EditText(this).apply { hint = "Feedback" }

        layout.addView(titleInput)
        layout.addView(artistInput)
        layout.addView(ratingInput)
        layout.addView(commentInput)

        AlertDialog.Builder(this)
            .setTitle("Add Music")
            .setView(layout)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString().toIntOrNull() ?: 0
                val comment = commentInput.text.toString()

                if (title.isNotBlank() && artist.isNotBlank() && rating in 1..5) {
                    songTitles.add(title)
                    artists.add(artist)
                    ratings.add(rating)
                    comments.add(comment)
                    Toast.makeText(this, "Added to playlist!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Oops! Please check your input.", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Dismiss", null)
            .show()
    }
}

