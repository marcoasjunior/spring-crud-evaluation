package com.evaluation.demo.controllers;

import com.evaluation.demo.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    public List<User> listUser();
    public ResponseEntity addUser(User user);
    public User viewUser(String id);
    public ResponseEntity editUser(User user);
    public ResponseEntity deleteUser(User user);
    public ResponseEntity saveUser(User user);

}
