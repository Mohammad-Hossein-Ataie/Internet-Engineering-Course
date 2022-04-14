package org.example.CA1.httpServlet;

import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        if(MovieDAO.getMovies().isEmpty()) {
            GetData.setMovieList();
            GetData.setActorsListData();
            GetData.setCommentsListData();
            GetData.setUsersListData();
        }
        String enteredMail = request.getParameter("email");
        UserDAO.addEnrolled(enteredMail);
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request,response);
    }

}
