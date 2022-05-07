package org.example.CA1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Utilities.ResponseGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @PostMapping("/logout")
    public void logout() {
        UserDAO.setEnrolledID("");
    }
}
