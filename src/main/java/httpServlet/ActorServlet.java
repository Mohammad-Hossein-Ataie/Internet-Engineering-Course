package httpServlet;

import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "actor", urlPatterns = "/actors/*")
public class ActorServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if(UserDAO.getEnrolledID() == ""){
            response.sendRedirect("/login");
        }
        else {
            String pathInf = request.getPathInfo();
            String[] path = pathInf.split("/");
            String actorId = path[1];

            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/actor.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
