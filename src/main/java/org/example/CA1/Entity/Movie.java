package org.example.CA1.Entity;

import java.util.*;
import java.util.stream.Collectors;

public class Movie {
    private int id;
    private String name;
    private String summary;
    private String releaseDate;
    private String director;
    private float rating;
    private List<Integer> cast = new ArrayList<>();
    private float imdbRate;
    private String duration;
    private int ageLimit;
    private List<String> writers = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    public HashMap<String, Float> ratingMap = new HashMap<String, Float>();
    private String movieImage;
    private String movieCoverImage;
    public void setRating(String email, float rating) {
        ratingMap.put(email, rating);
        this.rating += rating;
    }


    public String getMovieImage() {
        return movieImage;
    }

    public String getMovieCoverImage() {
        return movieCoverImage;
    }

    public Movie(int id, String name, String summary, String releaseDate, String director, List<String> writers, List<String> genres, List<Integer> cast,
                 float imdbRate, String duration, int ageLimit, String movieImage, String movieCoverImage) {
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
        this.movieImage = movieImage;
        this.movieCoverImage = movieCoverImage;
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

    public String getAgeLimitString() {
        return Integer.toString(ageLimit);
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public List<Integer> getCast() {
        return cast;
    }

    public void setCast(List<Integer> cast) {
        this.cast = cast;
    }

    public String getImdbRate() {
        return Float.toString(imdbRate);
    }

    public String getDuration() {
        return duration;
    }

    public List<String> getWriters() {
        return writers;
    }

    public String getWritersString() {
        return String.join(",", writers);
    }

    public String getGenreString() {
        return String.join(",", genres);
    }

    public String getCastString() {
        List<String> strings = cast.stream().map(Object::toString)
                .collect(Collectors.toList());
        return String.join(",", strings);
    }
    public List<String> getGenres() {
        return genres;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }
    public boolean isSame(Movie movie) {
        return this.id == movie.id;
    }
    //ToDo
    public String getRating() {
        return String.valueOf(rating);
    }

}