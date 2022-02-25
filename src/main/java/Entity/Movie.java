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

    public Movie(int id, String name, String summary, String releaseDate, String director, List<String> writers, List<String> genres, List<Actor> cast, float imdbRate, int duration, int ageLimit) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.director = director;
        this.writers = writers;
        this.genres = genres;
        this.cast = cast;
        this.imdbRate = imdbRate;
        this.duration = duration;
        this.ageLimit = ageLimit;
    }

    private int id;
    private String name;
    private String summary;
    private String releaseDate;
    private String director;
    private List<String> writers = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    public List<Actor> getCast() {
        return cast;
    }
    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }
    private List<Actor> cast = new ArrayList<>();
    private float imdbRate;
    private int duration;
    private int ageLimit;
    public boolean isSame(Movie movie) {
        return this.id == movie.id;
    }

}
