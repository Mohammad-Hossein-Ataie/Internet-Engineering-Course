package httpServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        GetData.setActorsListData();
        GetData.setMovieList();
        GetData.setUsersListData();
        GetData.setCommentsListData();
    }
    //Done
    //Add enteredMail to a list of mails in order to how is in
}
