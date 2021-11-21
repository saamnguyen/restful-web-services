package com.spring.restfulwebservices.controller;

import com.spring.restfulwebservices.exception.UserNotFoundException;
import com.spring.restfulwebservices.user.User;
import com.spring.restfulwebservices.user.UserDaoService;
import com.spring.restfulwebservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJPAController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> retriveAllUsers(){
        return userRepository.findAll();
    }

//    Error
//    @GetMapping("/jpa/users/{id}")
//    public Resource<User> retriveUser(@PathVariable int id){
//        Optional<User> user= userRepository.findById(id);
//        if(user.isPresent())
////runtime exception
//            throw new UserNotFoundException("id: "+ id);
////"all-users", SERVER_PATH + "/users"
////retrieveAllUsers
//        Resource<User> resource=new Resource<User>(user.get()); //constructor of Resource class
////add link to retrieve all the users
//        ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
//        resource.add(linkTo.withRel("all-users"));
//        return resource;
//    }

    @PostMapping("/jpa/users")
    public void createUser(@RequestBody User user){
//        User sevedUser = userDaoService.save(user);
        userRepository.save(user);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
