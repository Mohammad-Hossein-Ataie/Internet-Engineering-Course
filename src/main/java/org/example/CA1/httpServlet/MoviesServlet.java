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

@WebServlet(name = "movies", urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(UserDAO.getEnrolledID() == ""){
            response.sendRedirect("/login");
        }
        else {
            MovieDAO.setUserSearchedMovies(MovieDAO.getMovies());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/movies.jsp");
            requestDispatcher.forward(request, response);
        }
//        List<Movie> movies = MovieDAO.getMovies();
//        request.setAttribute("movies", movies); // Will be available as ${movies} in JSP
//        // If search button clicked
//        int id = -1;
//        id = MovieManager.getMovieByName(request.getParameter("movieName"));
//        Movie searchedMovie = MovieManager.getMovieById(Integer.valueOf(id));
//        request.setAttribute("movie", searchedMovie);
//        //
//        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/movies.jsp");
//        requestDispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{

        String act = request.getParameter("action");
        String nameSeach = request.getParameter("search");

        if(act != null){
            if(act.equals("search")){
                List<Movie> movies = MovieDAO.getMovieByName(nameSeach);
                MovieDAO.setUserSearchedMovies(movies);
            }
            else if(act.equals("clear")){
                MovieDAO.setUserSearchedMovies(MovieDAO.getMovies());
            }
            else if(act.equals("sort_by_imdb")){
                System.out.println("sort_by_imdb");
                MovieDAO.setUserSearchedMovies(MovieDAO.sortMovies(1));
            }
            else if(act.equals("sort_by_date")){
                System.out.println("sort_by_date");
                MovieDAO.setUserSearchedMovies(MovieDAO.sortMovies(0));
            }
        }
        else {
            MovieDAO.setUserSearchedMovies(MovieDAO.getMovies());
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/movies.jsp");
        requestDispatcher.forward(request, response);
    }
}
