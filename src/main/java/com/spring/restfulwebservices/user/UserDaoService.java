package com.spring.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    public static int userCount = 5;

    public static List<User> users = new ArrayList<>();

    static {
        //Create user
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Robert", new Date()));
        users.add(new User(3, "Adam", new Date()));
        users.add(new User(4, "Andrew", new Date()));
        users.add(new User(5, "Jack", new Date()));
    }

    //find all
    public List<User> findAll(){
        return users;
    }

    //add user
    public User save(User user){
        //If userId null
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    //find user by id
    public User findOne(int id){
        for (User user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
