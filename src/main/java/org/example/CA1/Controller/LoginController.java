package org.example.CA1.Controller;

import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Logedin;
import org.example.CA1.Entity.User;
import org.example.CA1.Manager.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody User user) throws Exception {
            if (user.getEmail() == null || user.getPassword() == null)
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Missing Parameter");

            if(UserManager.checkUser(user.getEmail())) {

                if(UserManager.checkPassword(user)){
                    UserDAO.addEnrolled(user.getEmail());
                }
                else{
                    throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Incorrect password.");
                }
        }
            else{
                throw new Exception("Not Registered!");
            }
    }
}
