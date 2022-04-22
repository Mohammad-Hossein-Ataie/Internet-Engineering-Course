package org.example.CA1.httpServlet;

import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "movie", urlPatterns = "/movies/*")
public class MovieServlet extends HttpServlet{
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if(UserDAO.getEnrolledID() == ""){
            response.sendRedirect("/login");
        }
        else {
            String pathInf = request.getPathInfo();
            String[] path = pathInf.split("/");
            String movieId = path[1];

            MovieDAO.setSelectedMovie(Integer.parseInt(movieId));

            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/movie.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String pathInf = request.getPathInfo();
        String[] path = pathInf.split("/");
        String movieId = path[1];

        String rate = request.getParameter("quantity");
        String comment = request.getParameter("comment");
        String addWatchList = request.getParameter("watchlist");
        if(rate != null){
            System.out.println(rate);
            Movie movie = MovieDAO.findByID(Integer.parseInt(movieId));
            movie.setRating(UserDAO.getEnrolledID(), Float.parseFloat(rate));
//            MovieDAO.updateRating(UserDAO.getEnrolledID(), movieId, rate);
        }
        if(comment != null){
            System.out.println(comment);
        }
        if(addWatchList != null){
            System.out.println(addWatchList);
            // add user to watchlist
        }

    }
}