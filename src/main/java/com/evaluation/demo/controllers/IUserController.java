package com.evaluation.demo.controllers;

import com.evaluation.demo.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    List<User> listUser();
    ResponseEntity addUser(User user);
    User viewUser(String id);
    ResponseEntity editUser(User user);
    ResponseEntity deleteUser(String id);
    ResponseEntity saveUser(User user);

}
