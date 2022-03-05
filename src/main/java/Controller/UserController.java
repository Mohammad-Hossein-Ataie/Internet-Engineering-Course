package Controller;

import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Movie;
import Entity.User;
import Manager.UserManager;
import Error.UserAlreadyExist;
import Error.AgeLimitError;
import Error.UserNotExist;

import java.util.List;

public class UserController {
    public static String addUser(User user) throws UserAlreadyExist {
        if (UserManager.uniqueMail(user)) {
            UserManager.addUser(user);
            return "user added successfully";
        } else {
            throw new UserAlreadyExist();
        }
    }
    public static String addToWatchList(String email, Integer movieId) throws AgeLimitError, UserNotExist {
        User user = UserDAO.getUserBymail(email);
        Movie movie = MovieDAO.getMovieByID(movieId);
        if (UserManager.uniqueMail(user)) {
            throw new UserNotExist();
        }
        else {
            if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
                UserManager.addToWatchList(user.getEmail(), movie.getId());
                return "movie added to watchlist successfully";
            } else {
                throw new AgeLimitError();
            }
        }
    }
    public static String removeFromWatchList(String email, Integer movieId) throws AgeLimitError, UserNotExist{
        User user = UserDAO.getUserBymail(email);
        Movie movie = MovieDAO.getMovieByID(movieId);
        if (UserManager.uniqueMail(user)) {
            throw new UserNotExist();
        }
        else {
            if (UserManager.checkAge(user.getBirthDate(), movie.getAgeLimit())) {
                UserManager.removeFromWatchList(user.getEmail(), movie.getId());
                return "movie removed from watchlist successfully";
            } else {
                throw new AgeLimitError();
            }
        }
    }
}
