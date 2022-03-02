package Entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String name;
    private String summary;
    private String releaseDate;
    private String director;
    private int totalLikes;
    private int totalDislikes;
    private List<Integer> cast = new ArrayList<>();
    private float imdbRate;
    private String duration;
    private int ageLimit;
    private List<String> writers = new ArrayList<>();
    private List<String> genres = new ArrayList<>();

    public Movie(int id, String name, String summary, String releaseDate, String director, List<String> writers, List<String> genres, List<Integer> cast, float imdbRate, String duration, int ageLimit) {
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

    public <E> Movie(int i, String film, String s, String s1, String john_star, ArrayList<E> john_son, ArrayList<E> action, int i1, double v, String s2) {
    }

    public int getId() {
        return id;
    }

    public List<String> getGenre() {
        return genres;
    }

    public void setId(int id) {
        this.id = id;
    }

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
