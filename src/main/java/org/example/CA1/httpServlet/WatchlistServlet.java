package org.example.CA1.httpServlet;

import org.example.CA1.DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "watchlist", urlPatterns = "/watchlist")
public class WatchlistServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(UserDAO.getEnrolledID() == ""){
            response.sendRedirect("/login");
        }
        else {
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/watchlist.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String removeMovie = request.getParameter("remove-movie");
        if(removeMovie != null){
            System.out.println(removeMovie);
            // add user to watchlist
        }
    }
}
