package org.example.CA1.Controller;

import org.example.CA1.DAO.ConnetctionPool;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Logedin;
import org.example.CA1.Entity.User;
import org.example.CA1.Manager.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody User user) throws Exception {
            if (user.getEmail() == null || user.getPassword() == null)
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Missing Parameter");
            Statement statement;
            try {
                Connection connection = ConnetctionPool.getConnection();
                String query = "SELECT * FROM user where email = ? and password = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, user.getEmail());
                preparedStmt.setString(2, String.valueOf(user.getPassword().hashCode()));
                ResultSet result = preparedStmt.executeQuery();
                if(result.next()) {
                    UserDAO.addEnrolled(user.getEmail());
                }
                else{
                    throw new Exception("Not Registered!");
                }
                result.close();
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
