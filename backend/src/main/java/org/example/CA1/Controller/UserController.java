package org.example.CA1.Controller;

import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;
import org.example.CA1.Error.*;
import org.example.CA1.Manager.UserManager;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public void addToWatchList(@PathVariable String email, @PathVariable Integer movieId) throws AgeLimitError, UserNotExist, SQLException {
        User user = UserDAO.getUserByMail(email);
        Movie movie = MovieDAO.getMovieByID(movieId);
        if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
            UserManager.addToWatchList(user, movie);
        } else {
            throw new AgeLimitError();
        }
    }
    @GetMapping("/watchlist/{email}")
    public Object[] getWatchlist(@PathVariable String email) throws SQLException {
        User user = UserDAO.getUserByMail(email);
        List<Movie> userwatchlist;
        userwatchlist = UserDAO.getWatchList(user);
        return new Object[]{userwatchlist};
    }
    @DeleteMapping("/watchlist/{movieId}")
    public void removeFromWatchList(@PathVariable Integer movieId) throws AgeLimitError, SQLException {
        User user = UserDAO.getUserByMail(UserDAO.getEnrolledID());
        Movie movie = MovieDAO.getMovieByID(movieId);
            if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
                UserManager.removeFromWatchList(movie.getId());
            } else {
                throw new AgeLimitError();
            }
    }
}
