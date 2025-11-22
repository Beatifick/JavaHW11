import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();

    @Test
    public void shouldUseDefaultLimit() {
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetCustomLimit() {
        PosterManager manager = new PosterManager(3);
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {

        manager.add("Movie1");

        String[] expected = {"Movie1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveralMovies() {

        manager.add("Movie1");
        manager.add("Movie2");
        manager.add("Movie3");

        String[] expected = {"Movie1", "Movie2", "Movie3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoviesLessThanLimit() {

        PosterManager manager = new PosterManager(5);

        manager.add("Movie1");
        manager.add("Movie2");
        manager.add("Movie3");

        String[] expected = {"Movie3", "Movie2", "Movie1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoviesEqualLimit() {

        PosterManager manager = new PosterManager(3);

        manager.add("Movie1");
        manager.add("Movie2");
        manager.add("Movie3");

        String[] expected = {"Movie3", "Movie2", "Movie1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoviesMoreThanLimit() {

        PosterManager manager = new PosterManager(3);

        manager.add("Movie1");
        manager.add("Movie2");
        manager.add("Movie3");
        manager.add("Movie4");
        manager.add("Movie5");

        String[] expected = {"Movie5", "Movie4", "Movie3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithDefaultLimitFive() {

        manager.add("Movie1");
        manager.add("Movie2");
        manager.add("Movie3");
        manager.add("Movie4");
        manager.add("Movie5");
        manager.add("Movie6");
        manager.add("Movie7");

        String[] expected = {"Movie7", "Movie6", "Movie5", "Movie4", "Movie3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
