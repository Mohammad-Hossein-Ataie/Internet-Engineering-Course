package org.example.CA1.DAO;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.regex.Pattern;

public class MovieDAO {
    private static Map<Integer, Movie>  movieIds = new HashMap<>();

    public static List<String> getUserID() {
        return userID;
    }

    public static void setUserID(List<String> userID) {
        MovieDAO.userID = userID;
    }

    private static List<String> userID = new ArrayList<>();
    private static Map<Integer,Integer> scoreMovies =new HashMap<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<Movie> UserSearchedMovies = new ArrayList<>();
    private static int selectedMovie;

    public static int getSelectedMovie() {
        return selectedMovie;
    }

    public static void setSelectedMovie(int id) {
        selectedMovie = id;
    }

    public static List<Movie> getUserSearchedMovies() {
        return UserSearchedMovies;
    }

    public static void setUserSearchedMovies(List<Movie> userMovies) {
        UserSearchedMovies = userMovies;
    }
    public static List<Movie> sortMovies(int mode){
        List<Movie> searchMovie = getUserSearchedMovies();
        if(searchMovie.isEmpty()){
            searchMovie = MovieDAO.getMovies();
        }

        if (mode == 1){
            //sort by imdb
            Collections.sort(searchMovie, Comparator.comparing(Movie::getImdbRate).reversed());
        }
        else if(mode == 2){
            //sort by date
            Collections.sort(searchMovie, Comparator.comparing(Movie::getReleaseDate).reversed());
        }
        return searchMovie;
    }
//    public static void setRateMovie(String userID,int rate,int movieId){
//        ArrayList userIDList = (ArrayList) getUserID();
//        if (userIDList.contains(userID)){
//
//        }
//        scoreMovies.put(movieId,rate);
//    }
//    public static void setMovies(List<Movie> newMovies) {
//        movies.addAll(newMovies);
//    }
    public static void setMovies(List<Movie> newMovies){
        Statement statement;
        try {
        Connection connection = ConnetctionPool.getConnection();
        statement = connection.createStatement();
        for(Movie movie:newMovies) {
            String query = "SELECT * FROM movie WHERE id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,movie.getId());
            ResultSet result = preparedStmt.executeQuery();
            if(result.next()){
                continue;
            }
            statement.close();
            query = " INSERT INTO movie (id, movie_name, summary, releaseDate, director,imdbRate,duration,ageLimit,image,coverImage,rating)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,movie.getId());
            preparedStmt.setString(2, movie.getName());
            preparedStmt.setString(3, movie.getSummary());
            preparedStmt.setString(4, movie.getReleaseDate());
            preparedStmt.setString(5, movie.getDirector());
            preparedStmt.setString(6,  movie.getImdbRate());
            preparedStmt.setString(7,movie.getDuration());
            preparedStmt.setInt(8,movie.getAgeLimit());
            preparedStmt.setString(9,movie.getMovieImage());
            preparedStmt.setString(10,movie.getMovieCoverImage());
            preparedStmt.setString(11,movie.getRating());
            preparedStmt.executeUpdate();
            //setCast
            query = " INSERT INTO casts(movieId,actorId)"
                    + " values (?, ?)";
            preparedStmt = connection.prepareStatement(query);
            for(int i = 0; i<movie.getCast().size(); i++) {
                preparedStmt.setInt(1, movie.getId());
                preparedStmt.setInt(2, movie.getCast().get(i));
                preparedStmt.executeUpdate();
            }
            query = " INSERT INTO genres(movieId,genres)"
                    + " values (?, ?)";
            preparedStmt = connection.prepareStatement(query);
            for(int i = 0; i<movie.getGenre().size(); i++) {
                preparedStmt.setInt(1, movie.getId());
                preparedStmt.setString(2, movie.getGenre().get(i));
                preparedStmt.executeUpdate();
            }
        }
            connection.close();
        } catch (
    SQLException e) {
        e.printStackTrace();
    }
}

//    public static float getRateMovie(Integer movieId){
//        int score = 0;
//        int count = 0;
//        for (Map.Entry<Integer, Integer> entry : scoreMovies.entrySet()) {
//            if(movieId == entry.getKey()) {
//                count = count + 1;
//                score = score + entry.getValue();
//            }
//        }
//        Movie newMovie = MovieDAO.findByID(movieId);
//        if (count == 0) {
//            newMovie.setRating(0);
//            return 0;
//        }
//        float rating = score/count;
//        newMovie.setRating(rating);
//        return rating;
//    }

    public static void update(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).isSame(movie))
                movies.set(i,movie);
        }
    }
    public static Movie findByID(int id){
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id)
                return movies.get(i);
        }
        return null;
    }
    public static void add(Movie movie) {

        movies.add(movie);
        movieIds.put(movie.getId(),movie);
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static Movie getMovieByID(Integer movieId) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM movie WHERE movie.id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, movieId);
            ResultSet res = preparedStmt.executeQuery();
            Movie movie = new Movie();
            movie.setId(res.getInt(1));
            movie.setName(res.getString(2));
            movie.setSummary(res.getString(3));
            movie.setReleaseDate(res.getString(4));
            movie.setDirector(res.getString(5));
            movie.setImdbRate(res.getFloat(6));
            movie.setDuration(res.getString(7));
            movie.setAgeLimit(res.getInt(8));
            movie.setImage(res.getString(9));
            movie.setCoverImage(res.getString(10));
            movie.setRating(res.getFloat(11));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void setCasts(){

    }
    public static void updateRating(String enrolledID, String movieId, String rate) {
        Movie movie = MovieDAO.getMovieByID(Integer.valueOf(movieId));
        userID.add(enrolledID);
        int usersize = userID.size();
        float frate = Float.parseFloat(rate);
        float currentRating = Float.parseFloat(movie.getRating());
        currentRating = ((currentRating + (frate)*usersize))/usersize;
        movie.setRating(currentRating);
    }
    public static List<Movie> getMoviesByGenre(String genre) {
//        List<Movie> movies = MovieDAO.getMovies();
//        System.out.println(movies.size());
//        List<Movie> moviesList = new ArrayList<>();
//        for (int i = 0; i < movies.size(); i++) {
//            for (int j = 0; j < movies.get(i).getGenre().size(); j++) {
//                if (movies.get(i).getGenre().get(j).equals(genre)) {
//                    moviesList.add(movies.get(i));
//                }
//            }
//        }
//        return movieList;
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM movie m JOIN genres g ON m.id = g.movieId  WHERE g.genre=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, genre);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()){
                Movie movie = new Movie();
                movie.setId(res.getInt(12));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Movie> getMovieByName(String movieName) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM movie WHERE movie.movie_name LIKE ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, movieName);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()) {
                Movie movie = new Movie();
                movie.setId(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Movie> getMovieByDate(String date) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM movie WHERE movie.releaseDate=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, date);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()) {
                Movie movie = new Movie();
                movie.setId(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
