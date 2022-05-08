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
    public void addComment(@RequestBody Comment comment) throws UserNotExist, MovieNotExist, SQLException {
        //TODO usernot exist
//        if (CommentManager.movieExist(comment)) {
//            if(CommentManager.userExist(comment))
//            {
                CommentManager.addComment(comment);
//            }
//            else {
//                throw new UserNotExist();
//            }
//        }
//        else {
//            throw new MovieNotExist();
//        }
    }
    @GetMapping("/movies/{movieID}/comments")
    public List<Comment> getComment(@PathVariable Integer movieID){
        List <Comment> temp;
        List <Comment> res = new ArrayList<>();
        temp = CommentDAO.getComments();
        for(int i = 0; i< temp.size(); i++){
            if(movieID.equals(temp.get(i).getMovieId())){
                res.add(temp.get(i));
            }
        }
        return res;
    }

    @PostMapping("/movies/{vote}/voteComment")
    public void voteComment(@PathVariable Integer vote, @PathVariable Integer id) {
        Comment comment = CommentDAO.getCommentByID(id);
        comment.setVote(vote);
    }
}
