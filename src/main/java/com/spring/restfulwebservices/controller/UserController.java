package com.spring.restfulwebservices.controller;

import com.spring.restfulwebservices.exception.UserNotFoundException;
import com.spring.restfulwebservices.user.User;
import com.spring.restfulwebservices.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id" + id);
        }
        //all user , serverpath + user
        //all user
        return user;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
//        User sevedUser = userDaoService.save(user);
        userDaoService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteUser(id);
        if(user == null){
            throw new UserNotFoundException("id" + id);
        }
    }
}
