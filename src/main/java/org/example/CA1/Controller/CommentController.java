package org.example.CA1.Controller;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Error.MovieNotExist;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Manager.CommentManager;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    @PostMapping("/movies/addComment")
    public void addComment(@RequestBody Comment comment) throws SQLException {
        //TODO usernot exist
        CommentManager.addComment(comment);
    }
    @GetMapping("/movies/{movieID}/comments")
    public List<Comment> getComment(@PathVariable Integer movieID) throws SQLException {
        List <Comment> temp;
        temp = CommentDAO.getComments(movieID);
        return temp;
    }

    @PostMapping("/movies/{vote}/voteComment")
    public void voteComment(@PathVariable Integer vote, @PathVariable Integer id) {
        Comment comment = CommentDAO.getCommentByID(id);
        comment.setVote(vote);
    }
}
