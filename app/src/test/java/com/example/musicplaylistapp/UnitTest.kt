package com.example.musicplaylistapp

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.After // If you need cleanup after each test

class PlaylistManagerTest {

    // These lists simulate the global/shared lists in your Activity
    // We'll clear them before each test to ensure isolation.
    private val songTitles = mutableListOf<String>()
    private val artists = mutableListOf<String>()
    private val ratings = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    // The helper function we want to test.
    // It's usually better to pass the lists into the function,
    // rather than relying on global variables, for easier testing.
    // For this example, we'll keep it as you last defined it for simplicity.
    private fun addSongToPlaylist(
        title: String,
        artist: String,
        rating: Int,
        comment: String
    ): Boolean {
        // Validate inputs
        if (title.isBlank() || artist.isBlank() || rating !in 1..5) {
            return false // Validation failed
        }

        // Add to the test lists
        songTitles.add(title)
        artists.add(artist)
        ratings.add(rating)
        comments.add(comment)
        return true // Success
    }

    // --- Test Setup and Teardown ---

    @Before // This method runs before EACH test
    fun setup() {
        // Clear lists to ensure each test starts with a clean state
        songTitles.clear()
        artists.clear()
        ratings.clear()
        comments.clear()
        println("Setup: Lists cleared.") // For debugging test flow
    }

    @After // This method runs after EACH test (optional, for cleanup)
    fun teardown() {
        println("Teardown: Test finished.")
    }

    // --- Actual Tests ---

    @Test
    fun `addSongToPlaylist returns true and adds song when input is valid`() {
        // Given valid input
        val title = "Test Song"
        val artist = "Test Artist"
        val rating = 4
        val comment = "Great tune!"

        // When adding the song
        val result = addSongToPlaylist(title, artist, rating, comment)

        // Then
        assertTrue("Should return true for valid input", result)
        assertTrue("Song title should be added", songTitles.contains(title))
        assertTrue("Artist should be added", artists.contains(artist))
        assertTrue("Rating should be added", ratings.contains(rating))
        assertTrue("Comment should be added", comments.contains(comment))
        println("Test 'valid input' passed.")
    }

    @Test
    fun `addSongToPlaylist returns false and does not add song when title is blank`() {
        // Given blank title
        val title = ""
        val artist = "Test Artist"
        val rating = 4
        val comment = "Great tune!"

        // When adding the song
        val result = addSongToPlaylist(title, artist, rating, comment)

        // Then
        assertFalse("Should return false for blank title", result)
        assertTrue("Song titles list should be empty", songTitles.isEmpty())
        println("Test 'blank title' passed.")
    }

    @Test
    fun `addSongToPlaylist returns false and does not add song when artist is blank`() {
        // Given blank artist
        val title = "Test Song"
        val artist = ""
        val rating = 4
        val comment = "Great tune!"

        // When adding the song
        val result = addSongToPlaylist(title, artist, rating, comment)

        // Then
        assertFalse("Should return false for blank artist", result)
        assertTrue("Artists list should be empty", artists.isEmpty())
        println("Test 'blank artist' passed.")
    }

    @Test
    fun `addSongToPlaylist returns false and does not add song when rating is out of range low`() {
        // Given rating too low
        val title = "Test Song"
        val artist = "Test Artist"
        val rating = 0 // Invalid rating
        val comment = "Great tune!"

        // When adding the song
        val result = addSongToPlaylist(title, artist, rating, comment)

        // Then
        assertFalse("Should return false for rating too low", result)
        assertTrue("Ratings list should be empty", ratings.isEmpty())
        println("Test 'rating too low' passed.")
    }

    @Test
    fun `addSongToPlaylist returns false and does not add song when rating is out of range high`() {
        // Given rating too high
        val title = "Test Song"
        val artist = "Test Artist"
        val rating = 6 // Invalid rating
        val comment = "Great tune!"

        // When adding the song
        val result = addSongToPlaylist(title, artist, rating, comment)

        // Then
        assertFalse("Should return false for rating too high", result)
        assertTrue("Ratings list should be empty", ratings.isEmpty())
        println("Test 'rating too high' passed.")
    }
}