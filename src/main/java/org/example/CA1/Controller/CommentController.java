package org.example.CA1.Controller;

import org.example.CA1.Entity.Comment;
import org.example.CA1.Manager.CommentManager;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Error.MovieNotExist;
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
