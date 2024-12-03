import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamCollectorTest
{

    private StreamCollector streamCollector;
    private List<StreamCollector.Book> books;
    private List<StreamCollector.Movie> movies;
    private List<StreamCollector.Movie> contemporaryMovies;
    private List<StreamCollector.Book> contemporaryBooks;
    private List<StreamCollector.Movie> moviesBasedOnBooks;
    private Map<String, List<StreamCollector.Movie>> moviesByDirector;
    private Map<String, List<StreamCollector.Book>> booksByAuthor;

    // Initilize Each expected result before 
    @BeforeEach
    public void setUp()
    {
    
    // LISTS

        // List of Books
        books = List.of(
            new StreamCollector.Book("Murder on the Orient Express", "Agatha Christie", 1934),
            new StreamCollector.Book("Death on the Nile", "Agatha Christie", 1937),
            new StreamCollector.Book("Frankenstein", "Mary Shelly", 1818),
            new StreamCollector.Book("Dracula", "Bram Stoker", 1896),
            new StreamCollector.Book("Minor Detail", "Adania Shibli", 2017),
            new StreamCollector.Book("Septology", "Jon Fosse", 2019),
            new StreamCollector.Book("Dune", "Frank Herbert", 1965)
        );

        // List of Movies
        movies = List.of(
            new StreamCollector.Movie("Murder on the Orient Express", "Kenneth Branagh", 2017),
            new StreamCollector.Movie("Frankenstein", "James Whale", 1932),
            new StreamCollector.Movie("Dracula", "Francis Ford Coppola", 1993),
            new StreamCollector.Movie("Apocalypse Now", "Francis Ford Coppola", 1979),
            new StreamCollector.Movie("The Pianist", "Roman Polanski", 2002),
            new StreamCollector.Movie("Dune", "David Villeneuve", 2021),
            new StreamCollector.Movie("Arrival", "David Villeneuve", 2016)
        );

        // Expected result for contemporaryBooks (releaseYear > 2003)
        contemporaryBooks = List.of(
            new StreamCollector.Book("Minor Detail", "Adania Shibli", 2017),
            new StreamCollector.Book("Septology", "Jon Fosse", 2019)
        );

        // Expected result for contemporaryMovies (releaseYear > 2003)
        contemporaryMovies = List.of(
            new StreamCollector.Movie("Murder on the Orient Express", "Kenneth Branagh", 2017),
            new StreamCollector.Movie("Dune 2", "David Villeneuve", 2024),
            new StreamCollector.Movie("Arrival", "David Villeneuve", 2016)
        );

        // Expected result for movies based on books (Not actually factually accurate : Just supposed to check for common titles across the lists, a more complete database would allow for accuracy)
        moviesBasedOnBooks = List.of(
            new StreamCollector.Movie("Murder on the Orient Express", "Kenneth Branagh", 2017),
            new StreamCollector.Movie("Frankenstein", "James Whale", 1932),
            new StreamCollector.Movie("Dracula", "Francis Ford Coppola", 1993),
            new StreamCollector.Movie("Dune", "David Villeneuve", 2021)
        );

    // HASH MAPS

        // Movies by director
        moviesByDirector = new HashMap<>();

        moviesByDirector.put("Kenneth Branagh", 
            List.of(new StreamCollector.Movie("Murder on the Orient Express", "Kenneth Branagh", 2017))
        );

        moviesByDirector.put("James Whale", 
            List.of(new StreamCollector.Movie("Frankenstein", "James Whale", 1932))
        );

        moviesByDirector.put("Francis Ford Coppola", 
            List.of(
                new StreamCollector.Movie("Dracula", "Francis Ford Coppola", 1993),
                new StreamCollector.Movie("Apocalypse Now", "Francis Ford Coppola", 1979)
            )
        );

        moviesByDirector.put("Roman Polanski", 
            List.of(new StreamCollector.Movie("The Pianist", "Roman Polanski", 2002))
        );

        moviesByDirector.put("David Villeneuve", 
            List.of(
                new StreamCollector.Movie("Dune 2", "David Villeneuve", 2024),
                new StreamCollector.Movie("Arrival", "David Villeneuve", 2016)
            )
        ); // End of Hash Map
    
    // GROUPED LISTS

        // Books by author
        booksByAuthor = new HashMap<>();

        booksByAuthor.put("Agatha Christie",
            List.of(
                new StreamCollector.Book("Murder on the Orient Express", "Agatha Christie", 1934),
                new StreamCollector.Book("Death on the Nile", "Agatha Christie", 1937)
            )
        );

        booksByAuthor.put("Mary Shelly",
            List.of(
                new StreamCollector.Book("Frankenstein", "Mary Shelly", 1818)
            )
        );

        booksByAuthor.put("Bram Stoker",
            List.of(
                new StreamCollector.Book("Dracula", "Bram Stoker", 1896)
            )
        );

        booksByAuthor.put("Adania Shibli",
            List.of(
                new StreamCollector.Book("Minor Detail", "Adania Shibli", 2017)
            )
        );
            
        booksByAuthor.put("Jon Fosse",
            List.of(
                new StreamCollector.Book("Septology", "Jon Fosse", 2019)
            )
        );

        booksByAuthor.put("Frank Herbert",
            List.of(
                new StreamCollector.Book("Dune", "Frank Herbert", 1965)
            )
        ); // End of Hash Map
        
        // Initilize StreamCollector
        streamCollector = new StreamCollector(books, movies);
    }

    // TESTS

    /* Test for PartitionBooksByReleaseYear function
       Expected Result : Pass
    */
    @Test
    public void testPartitionBooksByReleaseYear()
    {
        assertEquals(contemporaryBooks, streamCollector.PartitionBooksByReleaseYear(2003));
    }

    /* Test for PartitionMoviesByReleaseYear function
       Expected Result : Pass
    */
    @Test
    public void testPartitionMoviesByReleaseYear()
    {
        assertEquals(contemporaryMovies, streamCollector.PartitionMoviesByReleaseYear(2003));
       
    }

    /* Test for MoviesBasedOnBooks function
       Expected Result : Pass
    */
    @Test
    public void testMoviesBasedOnBooks()
    {
        
        assertEquals(moviesBasedOnBooks, streamCollector.MoviesBasedOnBooks());
        
    }

    /* Test for GroupMoviesByAuthor function
       Expected Result : Pass
    */
    @Test
    public void testGroupMoviesByDirector()
    {
        assertEquals(moviesByDirector, streamCollector.GroupMoviesByDirector());
        
    }

    /* Test for GroupBooksByAuthor function
       Expected Result : Pass
    */
    
    @Test
    public void testGroupBooksByAuthor()
    {
        assertEquals(booksByAuthor, streamCollector.GroupBooksByAuthor());
    }
}
