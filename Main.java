import java.util.Scanner;

/**
 * @author Ryan Espinoza, Siyoung Park
 * @version 1.0
 */

public class Main {

	/* ALGORITHM
	*
	1. Starts the program:
    -Allows you to chose between being a admin, a regular, or exiting the program.

	2. Admin Login:
    -When the user selects Admin (Option 1), the system proceeds to the Admin Menu where the admin has access to manage movies, including:
    -Option 1: Book a ticket (admin can book a ticket for themselves).
    -Option 2: Cancel a booking.
    -Option 3: Update movie details (admin can change movie title, director, genre, and number of available seats).
    -Option 4: Exit the admin menu.
    -Option 5: Go back to the login prompt, which exits the admin menu and takes the user back to the main login screen.

    3.Regular User Login:
    -When the user selects Regular User (Option 2), the system proceeds to the Regular User Menu where the regular user can:
    -Option 1: Book a ticket for one of the available movies.
    -Option 2: Cancel an existing ticket (if they have one).
    -Option 3: Exit the regular user menu.
    -Option 4: Go back to the login prompt, which exits the regular user menu and takes the user back to the main login screen.

    4:Regular User Login:
    When the user selects Regular User (Option 2), the system proceeds to the Regular User Menu where the regular user can:
    Option 1: Book a ticket for one of the available movies.
    Option 2: Cancel an existing ticket (if they have one).
    Option 3: Exit the regular user menu.
    Option 4: Go back to the login prompt, which exits the regular user menu and takes the user back to the main login screen.

    5:Ticket Booking and Cancellation:
    -For both Admin and Regular User, when booking or canceling a ticket:
    -The user is prompted to select a movie from a list.
    -The system checks if the movie is available for booking (seats are available).
    -If the user chooses to cancel a booking, the system checks if they have any tickets booked and proceeds with cancellation.

    6:Movie Updates (Admin Only):
    -The admin can select a movie and update its details (title, director, genre, and the number of available seats).
    -After editing the details, the system confirms that the update was successful.
    
    7:Exit and Return to Login:
    -Both the Admin and Regular User menus provide the option to exit and go back to the login screen. 
    If the user selects this, the current session ends and the program shows the login screen again.
	*
	*/
    public static void main(String[] args) {
        // Create an instance of Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Create movie instances (including the 3 new movies)
        Movie movie1 = new Movie("Inception", "Christopher Nolan", "Sci-Fi", 100);
        Movie movie2 = new Movie("The Dark Knight", "Christopher Nolan", "Action", 150);
        Movie movie3 = new Movie("Bocchi the Rock! The Movie", "Keiichirō Saitō", "Anime", 100);
        Movie movie4 = new Movie("The Boy and The Heron", "Miyazaki Hayao", "Anime", 100);
        Movie movie5 = new Movie("Spirited Away", "Miyazaki Hayao.", "Anime", 1000);

        // Create user instances (Admin and Regular User)
        AdminUser adminUser = new AdminUser("admin", "adminpass");
        RegularUser regularUser = new RegularUser("regular", "userpass");

        boolean running = true;
        while (running) {
            // Simulate login (For simplicity, let's assume the user logs in as Admin first)
            System.out.println("Login as:");
            System.out.println("1. Admin");
            System.out.println("2. Regular User");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (userChoice) {
                case 1:
                    // Admin login
                    adminMenu(adminUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 2:
                    // Regular User login
                    regularUserMenu(regularUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 3:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    // Admin menu
    private static void adminMenu(AdminUser adminUser, Movie movie1, Movie movie2, Movie movie3, Movie movie4, Movie movie5, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Update Movie Details");
            System.out.println("4. Exit");
            System.out.println("5. Go Back to Login");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Admin booking a ticket
                    bookTicket(adminUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 2:
                    // Admin canceling a ticket
                    cancelBooking(adminUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 3:
                    // Admin updating movie details
                    handleUpdateMovieDetails(adminUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 4:
                    // Exit the menu
                    running = false;
                    System.out.println("Exiting Admin Menu...");
                    break;
                case 5:
                    // Go back to the login menu
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Regular User menu
    private static void regularUserMenu(RegularUser regularUser, Movie movie1, Movie movie2, Movie movie3, Movie movie4, Movie movie5, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Regular User Menu =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Exit");
            System.out.println("4. Go Back to Login");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Regular user booking a ticket
                    bookTicket(regularUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 2:
                    // Regular user canceling a ticket
                    cancelBooking(regularUser, movie1, movie2, movie3, movie4, movie5, scanner);
                    break;
                case 3:
                    // Exit the menu
                    running = false;
                    System.out.println("Exiting Regular User Menu...");
                    break;
                case 4:
                    // Go back to the login menu
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    //method for regular user booking a ticket
    private static void bookTicket(User user, Movie movie1, Movie movie2, Movie movie3, Movie movie4, Movie movie5, Scanner scanner) {
        System.out.println("Available Movies:");
        System.out.println("1. " + movie1.getTitle());
        System.out.println("2. " + movie2.getTitle());
        System.out.println("3. " + movie3.getTitle());
        System.out.println("4. " + movie4.getTitle());
        System.out.println("5. " + movie5.getTitle());

        System.out.print("Enter movie number (1-5): ");
        int movieChoice = scanner.nextInt();
        System.out.print("Enter number of seats to book: ");
        int seats = scanner.nextInt();
        scanner.nextLine();

        Movie selectedMovie = null;
        switch (movieChoice) {
            case 1: selectedMovie = movie1; break;
            case 2: selectedMovie = movie2; break;
            case 3: selectedMovie = movie3; break;
            case 4: selectedMovie = movie4; break;
            case 5: selectedMovie = movie5; break;
            default:
                System.out.println("Invalid movie choice.");
                return;
        }

        try {
            user.bookTicket(selectedMovie, seats);
        } catch (MovieNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method for regular user canceling a booking
    private static void cancelBooking(User user, Movie movie1, Movie movie2, Movie movie3, Movie movie4, Movie movie5, Scanner scanner) {
        System.out.println("Available Movies:");
        System.out.println("1. " + movie1.getTitle());
        System.out.println("2. " + movie2.getTitle());
        System.out.println("3. " + movie3.getTitle());
        System.out.println("4. " + movie4.getTitle());
        System.out.println("5. " + movie5.getTitle());

        System.out.print("Enter movie number (1-5): ");
        int movieChoice = scanner.nextInt();
        System.out.print("Enter number of seats to cancel: ");
        int seats = scanner.nextInt();
        scanner.nextLine();

        Movie selectedMovie = null;
        switch (movieChoice) {
            case 1: selectedMovie = movie1; break;
            case 2: selectedMovie = movie2; break;
            case 3: selectedMovie = movie3; break;
            case 4: selectedMovie = movie4; break;
            case 5: selectedMovie = movie5; break;
            default:
                System.out.println("Invalid movie choice.");
                return;
        }
        user.cancelBooking(selectedMovie, seats);
    }

    // Helper method for admin to update movie details
    private static void handleUpdateMovieDetails(AdminUser adminUser, Movie movie1, Movie movie2, Movie movie3, Movie movie4, Movie movie5, Scanner scanner) {
        System.out.println("Select the movie to update:");
        System.out.println("1. " + movie1.getTitle());
        System.out.println("2. " + movie2.getTitle());
        System.out.println("3. " + movie3.getTitle());
        System.out.println("4. " + movie4.getTitle());
        System.out.println("5. " + movie5.getTitle());

        System.out.print("Enter movie number (1-5): ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Movie selectedMovie = null;
        switch (movieChoice) {
            case 1: selectedMovie = movie1; break;
            case 2: selectedMovie = movie2; break;
            case 3: selectedMovie = movie3; break;
            case 4: selectedMovie = movie4; break;
            case 5: selectedMovie = movie5; break;
            default:
                System.out.println("Invalid movie choice.");
                return;
        }

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new director: ");
        String newDirector = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter new number of seats: ");
        int newSeats = scanner.nextInt();
        scanner.nextLine(); 

        adminUser.updateMovieDetails(selectedMovie, newTitle, newDirector, newGenre, newSeats);
        System.out.println("Movie details updated successfully.");
    }
}
