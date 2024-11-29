
/*
 * Tester program for Movie class. Tests key methods to ensure they work as expected.
 *
 * @version 1.0


public class MovieTester {

    public static void main(String[] args) {
        // Create a movie object to test
        Movie movie = new Movie("Inception", "Christopher Nolan", "Sci-Fi", 100);

        // Test the Movie class methods
        testGetDetails(movie);
        testUpdateAvailableSeats(movie, 5); // Simulate booking 5 tickets
        testUpdateAvailableSeats(movie, 200); // Simulate booking more tickets than available
        testFreeSeats(movie, 3); // Simulate canceling 3 tickets
        testFreeSeats(movie, 10); // Simulate canceling more tickets than booked
        testUpdateMovieDetails(movie, "The Dark Knight", "Christopher Nolan", "Action", 150);
        testUpdateMovieDetails(movie, "", "Christopher Nolan", "Action", 150); // Test invalid title
    }

    /*
     * Test the getDetails() method to display the movie details.

    public static void testGetDetails(Movie movie) {
        System.out.println("\n===== Movie Details =====");
        System.out.println(movie.getDetails());
    }

    /*
     * Test the updateAvailableSeats() method for booking tickets.
     * @param movie the Movie object
     * @param ticketsToBook number of tickets to book

    public static void testUpdateAvailableSeats(Movie movie, int ticketsToBook) {
        System.out.println("\n===== Booking Tickets =====");
        System.out.println("Attempting to book " + ticketsToBook + " tickets...");
        try {
            movie.updateAvailableSeats(ticketsToBook);
            System.out.println("Successfully booked " + ticketsToBook + " tickets.");
        } catch (MovieNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * Test the freeSeats() method for canceling tickets.
     * @param movie the Movie object
     * @param ticketsToCancel number of tickets to cancel

    public static void testFreeSeats(Movie movie, int ticketsToCancel) {
        System.out.println("\n===== Cancelling Tickets =====");
        System.out.println("Attempting to cancel " + ticketsToCancel + " tickets...");
        try {
            movie.freeSeats(ticketsToCancel);
            System.out.println("Successfully canceled " + ticketsToCancel + " tickets.");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * Test the updateMovieDetails() method to update movie details.
     * @param movie the Movie object
     * @param newTitle the new movie title
     * @param newDirector the new movie director
     * @param newGenre the new movie genre
     * @param newAvailableSeats the new available seats count

    public static void testUpdateMovieDetails(Movie movie, String newTitle, String newDirector, String newGenre, int newAvailableSeats) {
        System.out.println("\n===== Updating Movie Details =====");
        System.out.println("Attempting to update movie details to:");
        System.out.println("Title: " + newTitle);
        System.out.println("Director: " + newDirector);
        System.out.println("Genre: " + newGenre);
        System.out.println("Available Seats: " + newAvailableSeats);

        try {
            movie.updateMovieDetails(newTitle, newDirector, newGenre, newAvailableSeats);
            System.out.println("Movie details updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
*/
