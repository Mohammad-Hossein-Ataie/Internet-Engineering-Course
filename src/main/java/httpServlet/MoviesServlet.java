package httpServlet;

import DAO.MovieDAO;
import Entity.Movie;
import Manager.MovieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/movies")
public class MoviesServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Movie> movies = MovieDAO.getMovies();
        request.setAttribute("movies", movies); // Will be available as ${movies} in JSP
        // If search button clicked
        int id = -1;
        id = MovieManager.getMovieByName(request.getParameter("movieName"));
        Movie searchedMovie = MovieManager.getMovieById(Integer.valueOf(id));
        request.setAttribute("movie", searchedMovie);
        //
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/movies.jsp");
        requestDispatcher.forward(request,response);
    }
    public void doPost()throws IOException,ServletException{

    }
}
