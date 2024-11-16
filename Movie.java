class Movie{

    private String title;
    private String director;
    private String genre;
    private int totalSeats;
    private int availableSeats;

    public Movie(String title, String director, String genre, int availableSeats) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty.");
        }
        if (director == null || director.isEmpty()) {
            throw new IllegalArgumentException("Movie director cannot be empty.");
        }
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Movie genre cannot be empty.");
        }
        if (availableSeats < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative.");
        }
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }



 // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getDetails(){
        return "Movie Title: " + title + "\n" +"Director: " + director + "\n" +"Genre: " + genre + "\n" +"Available Seats: " + availableSeats;
    }
    // Setter with validation to ensure total seats are positive
    public void setTotalSeats(int totalSeats) {
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Total seats must be a positive number.");
        }
        this.totalSeats = totalSeats;
    }

    public void updateAvailableSeats(int ticketsToBook) throws MovieNotAvailableException {
        if (ticketsToBook > availableSeats) {
            // Throw MovieNotAvailableException if there aren't enough available seats
            throw new MovieNotAvailableException("Not enough available seats for movie: " + title);
        }
        // Otherwise, update the available seats
        availableSeats -= ticketsToBook;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void freeSeats(int seatsFreed) {
        if (seatsFreed <= 0) {
            throw new IllegalArgumentException("Seats freed must be a positive number.");
        }
        if (availableSeats + seatsFreed > totalSeats) {
            throw new IllegalStateException("Cannot free more seats than total seats.");
        }
        availableSeats += seatsFreed;
    }

    // Method to update movie details
    public void updateMovieDetails(String newTitle, String newDirector, String newGenre, int newAvailableSeats) {
        if (newTitle == null || newTitle.isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty.");
        }
        if (newDirector == null || newDirector.isEmpty()) {
            throw new IllegalArgumentException("Movie director cannot be empty.");
        }
        if (newGenre == null || newGenre.isEmpty()) {
            throw new IllegalArgumentException("Movie genre cannot be empty.");
        }
        if (newAvailableSeats < 0) {
            throw new IllegalArgumentException("Available seats cannot be negative.");
        }

        this.title = newTitle;
        this.director = newDirector;
        this.genre = newGenre;
        this.availableSeats = newAvailableSeats;
    }

    public boolean isFullyBooked() {
        return availableSeats == 0;
    }

}