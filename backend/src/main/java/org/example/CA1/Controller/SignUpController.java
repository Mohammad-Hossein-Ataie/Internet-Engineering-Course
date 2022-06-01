package org.example.CA1.Controller;

import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SignUpController {
        @PostMapping("/signup")
    public void signup(@RequestBody User user) throws SQLException {
        UserDAO.addEnrolled(user.getEmail());
        String userPassword = user.getPassword();
        String hashedPassword = String.valueOf(userPassword.hashCode());
        user.setPassword(hashedPassword);
        UserDAO.addUser(user);
        List <User> users = new ArrayList<>();
        users.add(user);
        UserDAO.setUsers(users);
    }
}

