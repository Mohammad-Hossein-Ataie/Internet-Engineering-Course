package org.example.CA1.Controller;

import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;
import org.example.CA1.Error.*;
import org.example.CA1.Manager.UserManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    public static String addUser(User user) throws UserAlreadyExist {
        if (UserManager.uniqueMail(user)) {
            UserManager.addUser(user);
            return "user added successfully";
        } else {
            throw new UserAlreadyExist();
        }
    }
    @PostMapping("/movies/{movieId}/{email}")
    public void addToWatchList(@PathVariable String email, @PathVariable Integer movieId) throws AgeLimitError, UserNotExist {
        User user = UserDAO.getUserBymail(email);
        Movie movie = MovieDAO.getMovieByID(movieId);
        if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
            UserManager.addToWatchList(user.getEmail(), movie.getId());
        } else {
            throw new AgeLimitError();
        }
    }
    @GetMapping("/watchlist/{email}")
    public Object[] getWatchlist(@PathVariable String email) {
        User user = UserDAO.getUserBymail(email);
        Map<String, Integer> watchlist =  UserDAO.getWatchListUser();
        List<Movie> userwatchlist = new ArrayList<>();
//        for ( Map.Entry<String, Integer> entry : watchlist.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            userwatchlist.add(MovieDAO.getMovieByID(value));
//        }
        userwatchlist = user.getWatchList();
        return new Object[]{userwatchlist};
    }
    @DeleteMapping("/watchlist/{movieId}")
    public void removeFromWatchList(@PathVariable Integer movieId) throws AgeLimitError{
        User user = UserDAO.getUserBymail(UserDAO.getEnrolledID());
        Movie movie = MovieDAO.getMovieByID(movieId);
            if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
                System.out.println(UserDAO.getWatchListUser());
                UserManager.removeFromWatchList(user.getEmail(), movie.getId());
                System.out.println(UserDAO.getWatchListUser());
            } else {
                throw new AgeLimitError();
            }
    }
}
