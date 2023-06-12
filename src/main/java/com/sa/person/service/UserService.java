/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sa.person.service;

import com.sa.person.model.User;
import com.sa.person.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramip
 */

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public Optional<User> findById(Long id){
    return userRepository.findById(id);
    }

    public Optional<User> login(String email, String pass) {
        return userRepository.findByEmail(email);
    }
}
