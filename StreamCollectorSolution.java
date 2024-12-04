import java.util.*;
import java.util.stream.*;

public class StreamCollectorSolution
{
    // Example Classes Lab Questions
    record Book(String title, String author, int releaseYear){}
    record Movie(String title, String director, int releaseYear){}

    // Instance Lists
    List<Book> books;
    List<Movie> movies;

    // Q1.a Constructor
    public StreamCollectorSolution(List<Book> books, List<Movie> movies)
    {
        this.books = books;
        this.movies = movies;
    }

    // Q1.b Getters

    public Stream<Book> getBookStream()
    {
        return books.stream();
    }

    
    public Stream<Movie> getMovieStream()
    {
        return movies.stream();
    }

    // Q2 Partitions By Release Year

    public List<Book> PartitionBooksByReleaseYear(int partitionYear)
    {
        Map<Boolean, List<Book>> partitionedBooks = getBookStream()
            .collect(Collectors.partitioningBy(book -> book.releaseYear > partitionYear));

        // Print the partitions
        System.out.println("Contemporary books");
        partitionedBooks.get(true).forEach(System.out::println);
        
        System.out.println("");

        System.out.println("Classics");
        partitionedBooks.get(false).forEach(System.out::println);

        List<Book> contemporaryBooks = partitionedBooks.get(true);

        return contemporaryBooks;
    }

    public List<Movie> PartitionMoviesByReleaseYear(int partitionYear)
    {
        Map<Boolean, List<Movie>> partitionedMovies = getMovieStream()
            .collect(Collectors.partitioningBy(movie -> movie.releaseYear > partitionYear));

        // Print the partitions
        System.out.println("Contemporary movies");
        partitionedMovies.get(true).forEach(System.out::println);
        
        System.out.println("");

        System.out.println("Classics");
        partitionedMovies.get(false).forEach(System.out::println);

        List<Movie> contemporaryMovies = partitionedMovies.get(true);
        return contemporaryMovies;
    }

    // Q3 Movies Based on Books

    public List<Movie> MoviesBasedOnBooks()
    {
        System.out.println("\nMovies Based on Books\n");

        List<Movie> moviesBasedOnBooks = getMovieStream()
        .filter(movie -> getBookStream()
            .anyMatch(book -> movie.title.contains(book.title)))
        .collect(Collectors.toList());

        moviesBasedOnBooks.forEach(System.out::println);

        return moviesBasedOnBooks;
    }

    // Q4 Grouping by creator

    public Map<String, List<Movie>> GroupMoviesByDirector()
    {
        Map<String, List<Movie>> moviesByDirector = getMovieStream()
            .collect(Collectors.groupingBy(movie -> movie.director));

        moviesByDirector.forEach((director, movieList) -> {
            System.out.println(director + ": " + movieList);
        });

        return moviesByDirector;
    }

    public Map<String, List<Book>> GroupBooksByAuthor()
    {
        Map<String, List<Book>> booksByAuthor = getBookStream()
            .collect(Collectors.groupingBy(book -> book.author));

        booksByAuthor.forEach((author, bookList) -> {
            System.out.println(author + ": " + bookList);
        });

        

        return booksByAuthor;
    }

    // Main
    public static void main(String args [])
    {
        // List of books
        List<Book> books = List.of(
            new Book("Murder on the Orient Express", "Agatha Christie", 1934),
            new Book("Death on the Nile", "Agatha Christie", 1937),
            new Book("Frankenstein", "Mary Shelly", 1818),
            new Book("Dracula", "Bram Stoker", 1896),
            new Book("Minor Detail", "Adania Shibli", 2017),
            new Book("Septology", "Jon Fosse", 2019),
            new Book("Dune", "Frank Herbert", 1965)
        );
        
        // List of movies
        List<Movie> movies = List.of(
            new Movie("Murder on the Orient Express", "Kenneth Branagh", 2017),
            new Movie("Frankenstein", "James Whale", 1932),
            new Movie("Dracula", "Francis Ford Coppola", 1993),
            new Movie("Apocolypse Now", "Francis Ford Coppola", 1979),
            new Movie("The Pianist", "Roman Polanski", 2002),
            new Movie("Dune", "David Villeneuve", 2021), 
            new Movie("Arrival", "David Villeneuve", 2016)
        );

        System.out.print("\n\nMain Function : Exercise 2\n\n");

        StreamCollectorSolution collector = new StreamCollectorSolution(books, movies);

        collector.PartitionBooksByReleaseYear(2003); // Q2.1
        collector.PartitionMoviesByReleaseYear(2003); // Q2.2
        collector.MoviesBasedOnBooks(); // Q3
        collector.GroupMoviesByDirector(); // Q4.1
        collector.GroupBooksByAuthor(); // Q4.2
    }
}


