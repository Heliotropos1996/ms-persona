package com.sa.person.controller;

import com.sa.person.model.User;
import com.sa.person.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramip
 */

@RestController
//@RequestMapping("/login")
public class UserController {
    
    @Autowired
    UserService userService;
    
    
  /*  @PostMapping()
    public Optional<User> login(String email, String pass){
    return userService.login(email, pass);
    }*/
}
