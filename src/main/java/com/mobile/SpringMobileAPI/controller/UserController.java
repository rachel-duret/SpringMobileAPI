package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.entity.User;
import com.mobile.SpringMobileAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mobile")
public class UserController {
    @Autowired
    private UserService userService;

    //    Add one Client
    @PostMapping("/users")
    public @ResponseBody String addOneUser(@RequestBody User newUser){
        userService.addOneUser(newUser);
        return "New client Added.";
    }

//    Get all users list
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    public Optional<User> getOneUser(@PathVariable int id){
        return userService.getOneUser(id);
    }

    @PutMapping("/users/{id}")
    public @ResponseBody String updateOneUser(@RequestBody User newUser, @PathVariable int id){
       userService.getOneUser(id)
                .map(
                user->{
                   user.setUsername(newUser.getUsername());
                   user.setEmail(newUser.getEmail());
                   return userService.addOneUser(user);
                }
        );
        return "Client updated .";
    }

//    Delete one Client
    @DeleteMapping("/users/{id}")
    public void deleteOneUser(@PathVariable int id){
        userService.deleteOneUser(id);
    }

}
