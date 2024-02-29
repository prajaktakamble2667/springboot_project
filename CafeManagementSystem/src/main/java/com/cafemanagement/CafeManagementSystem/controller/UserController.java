package com.cafemanagement.CafeManagementSystem.controller;


import com.cafemanagement.CafeManagementSystem.model.User;
import com.cafemanagement.CafeManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    private List<User> getAllUser() {
        return userRepository.findAll();
    }

    //find customer by id
    @GetMapping(value = "/users/{id}")
    private User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    //adding user
    @PostMapping(value = "/users")
    private User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    //updating user
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user){
        try{
            User existUser = getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }

    }

    //Deleting the employee details by id
    @DeleteMapping(value = "/users1/{id}")
    private void deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
    }



}

