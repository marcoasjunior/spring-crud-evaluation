package com.evaluation.demo.repos;

import com.evaluation.demo.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

}