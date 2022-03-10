package httpServlet;

import DAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    String enteredMail = "";
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        enteredMail = request.getParameter("email");
        UserDAO.addEnrolled(enteredMail);
    }
    //Done
    //Add enteredMail to a list of mails in order to how is in
}
