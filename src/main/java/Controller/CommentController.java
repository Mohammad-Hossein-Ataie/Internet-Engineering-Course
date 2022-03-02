package Controller;

import Entity.User;
import Manager.UserManager;
import Entity.Comment;
import Manager.CommentManager;
import Error.UserNotExist;
import Error.MovieNotExist;
public class CommentController {
    public static String addComment(Comment comment) throws UserNotExist, MovieNotExist {
        if (CommentManager.movieExist(comment)) {
            if(CommentManager.userExist(comment))
            {   CommentManager.addComment(comment);
                return "user added successfully";
            }
            else {
                throw new UserNotExist();
            }
        }
        else {
            throw new MovieNotExist();
        }
    }
}
