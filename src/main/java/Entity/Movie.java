package Entity;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String id;
    private String name;
    private String summary;
    private String releaseDate;
    private String director;
    private List<String> writers = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<Actor> cast = new ArrayList<>();
    private float imdbRate;
    private int duration;
    private int ageLimit;
}
