public class AdminUser extends User {
    // Constructor for AdminUser
    public AdminUser(String username, String password) {
        super(username, password);
        this.maxBookings = Integer.MAX_VALUE; // Admins can book an unlimited number of tickets
    }

    // Book tickets for a movie (same as regular user, but admins can book unlimited)
    @Override
    public void bookTicket(Movie movie, int seats) throws MovieNotAvailableException {
        movie.updateAvailableSeats(seats);
        currentBookings += seats;
        System.out.println("Admin successfully booked " + seats + " tickets for movie: " + movie.getTitle());
    }

    // Cancel tickets for a movie (same as regular user)
    @Override
    public void cancelBooking(Movie movie, int seats) {
        if (seats <= currentBookings) {
            movie.freeSeats(seats);
            currentBookings -= seats;
            System.out.println("Admin successfully canceled " + seats + " tickets for movie: " + movie.getTitle());
        } else {
            System.out.println("Admin cannot cancel more tickets than are booked.");
        }
    }

    // Admin can add or update movie details
    public void updateMovieDetails(Movie movie, String newTitle, String newDirector, String newGenre, int newAvailableSeats) {
        movie.updateMovieDetails(newTitle, newDirector, newGenre, newAvailableSeats);
        System.out.println("Admin updated movie details: " + movie.getDetails());
    }

    // Admin can remove a movie
    public void removeMovie(Movie movie) {
        // Simulate movie removal, possibly setting the movie to null or removing from a list
        System.out.println("Admin has removed the movie: " + movie.getTitle());
    }
}