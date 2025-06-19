# PRACTICUM-EXAM
STUDENT NAME : DALIAN NAVECK FRANSEL MATSIKA 
STUDENT NUMBER : ST104923476

My Application is a mobile app for managing personal song collections. It lets users add music with details and ratings, browse playlists, and calculate the average rating of songs within a playlist.

github code : https://github.com/Dalianmatsika/PRACTICUM-EXAM.gitss

![Alt text](Screenshot_20250619_121111-2.png)
*This is the main screen of the "Auto Fire Music" app, offering options to add to or browse playlists, exit, and displaying a "Welcome" message along with a recent "Oops! Please check your input" error notification.*

![Alt text](Screenshot_20250619_121142-1.png)
*This screen is an "Add Music" form within the "Auto Fire Music" app, allowing users to input song details (title, artist, rating, feedback) before adding them to a playlist, with options to "DISMISS" or "ADD" the entry.*

![Alt text](Screenshot_20250619_121201-1.png)
*This "Playlist information" screen in the "Auto Fire Music" app is currently blank but offers a "Calculate Average Rating" function for the playlist and a "Return to Main" button.*

![Alt text](Screenshot_20250619_121212-1.png)
This screen, within the "Auto Fire Music" app, indicates an empty playlist with the message "No scores yet. Care to add the first one?", prompting the user to add music, while still offering "Calculate Average Rating" (though currently meaningless) and "Return to Main" options.

![Alt text](Screenshot_20250619_121241-1.png)
*This screen displays the "Add Music" form with user-entered data, where the "Track Title" field is highlighted in red, indicating invalid input, likely after a failed attempt to add music.*

![Alt text](Screenshot_20250619_121314-1.png)
*This is the main screen of the "Auto Fire Music" app, showing options to "ADD TO PLAYLIST," "Browse playlist," and "Exit," along with a "Welcome" message and an "Oops! Please check your input." notification(handling error).*

![Alt text](<Screenshot 2025-06-19 120811.png>)
*This code gathers a song title, artist, rating (1-5), and feedback. Upon submission, it validates if title and artist are not blank and if the rating is within 1-5. If valid, it adds the data and shows an "Added to playlist!" toast; otherwise, it displays an "Oops! Please check your input." error toast.*

![Alt text](<Screenshot 2025-06-19 121031.png>)
*This code retrieves song titles, artists, ratings, and comments via `Intent`. It populates a `ListView` with these songs and handles a "Calculate Average Rating" button: if ratings exist, it computes and displays the average; otherwise, it shows a "No scores yet" message. A "Return to Main" button closes the activity.*



