package Day1.Level1;
class Movie {
    //attributes
    String title;
    String director;
    int year;
    double rating;
    //node next
    Movie next;
    //node prev
    Movie prev;

    //constructor of class movie
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;

        //settting next and prev to null
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    // head and tail f
    private Movie head;
    private Movie tail;

    // Adding a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Adding a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Removing a movie by title
    public void removeMovie(String title) {
        if (head == null) return;
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // Search movies by director name
    public void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Searching movies by rating
    public void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating >= rating) {
                System.out.println(temp.title + " (" + temp.year + ") - Director: " + temp.director);
            }
            temp = temp.next;
        }
    }

    // Displaying movies in forward order
    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Displaying movies in reverse order
    public void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    // Updating movie rating based on title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Adding movies detail
        movieList.addMovieAtEnd("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        movieList.addMovieAtBeginning("Sholay", "Ramesh Sippy", 1975, 9.0);
        movieList.addMovieAtEnd("Dilwale Dulhania Le Jayenge", "Aditya Chopra", 1995, 8.5);
        movieList.addMovieAtBeginning("Gully Boy", "Zoya Akhtar", 2019, 8.2);

        System.out.println("Movies (Forward Order):");
        movieList.displayMoviesForward();

        System.out.println("\nMovies (Reverse Order):");
        movieList.displayMoviesReverse();

        System.out.println("\nSearching by Director: Rajkumar Hirani");
        movieList.searchByDirector("Rajkumar Hirani");

        System.out.println("\nUpdating Rating for 3 Idiots:");
        movieList.updateRating("3 Idiots", 9.1);
        movieList.displayMoviesForward();

        System.out.println("\nRemoving Sholay and displaying list:");
        movieList.removeMovie("Sholay");
        movieList.displayMoviesForward();
    }
}