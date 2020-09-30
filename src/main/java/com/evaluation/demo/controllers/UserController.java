package com.evaluation.demo.controllers;

import com.evaluation.demo.models.User;
import com.evaluation.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class UserController implements IUserController {

    @Autowired
    private UserRepo repo;


    @Override
    @GetMapping("/index")
    public List<User> listUser() {
        return (List<User>) repo.findAll();
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {

        repo.save(user);

        return new ResponseEntity(HttpStatus.CREATED);


    }

    @Override
    @GetMapping()
    public User viewUser(@RequestParam String id) {

        Integer userId = Integer.parseInt(id);

        return repo.findById(userId).get();
    }

    @Override
    @PutMapping
    public ResponseEntity editUser(@RequestBody User user) {

        repo.save(user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @Override
    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody User user) {

        repo.delete(user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user) {

        repo.save(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
