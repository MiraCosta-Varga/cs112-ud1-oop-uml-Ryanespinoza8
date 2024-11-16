public abstract class User {
    protected String username;
    protected String password;
    protected int maxBookings;
    protected int currentBookings;

    // Constructor
    public User(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }

        this.username = username;
        this.password = password;
        this.maxBookings = 5; // Default max bookings for a regular user
        this.currentBookings = 0;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxBookings() {
        return maxBookings;
    }

    public int getCurrentBookings() {
        return currentBookings;
    }

    // Abstract methods to be implemented by concrete classes
    public abstract void bookTicket(Movie movie, int seats) throws MovieNotAvailableException;

    public abstract void cancelBooking(Movie movie, int seats);

    // Method to check if user has reached the max bookings
    public boolean canBook() {
        return currentBookings < maxBookings;
    }
}