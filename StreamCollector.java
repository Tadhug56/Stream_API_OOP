import java.util.*;
import java.util.stream.*;

public class StreamCollector
{
    // Example Classes Lab Questions
    record Book(String title, String author, int releaseYear){}
    record Movie(String title, String director, int releaseYear){}

    // Instance Lists
    List<Book> books;
    List<Movie> movies;

    // Q1.a Constructor
    public StreamCollector(List<Book> books, List<Movie> movies)
    {

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

        StreamCollector collector = new StreamCollector(books, movies);
    }
}


