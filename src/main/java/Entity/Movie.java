package Entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String summary;
    private String releaseDate;
    private String director;
    private float imdbRate;
    private String duration;
    private int ageLimit;
    private List<String> writers = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<Integer> cast = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public List<Integer> getCast() {
        return cast;
    }

    public void setCast(List<Integer> cast) {
        this.cast = cast;
    }

    public boolean isSame(Movie movie) {
        return this.id == movie.id;
    }

}
