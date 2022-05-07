package org.example.CA1.Controller;

import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SignUpController {
        @PostMapping("/signup")
    public void signup(@RequestBody User user) {
        UserDAO.addEnrolled(user.getEmail());
        UserDAO.addUser(user);
    }
}

