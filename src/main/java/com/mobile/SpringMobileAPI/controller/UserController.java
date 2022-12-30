package com.mobile.SpringMobileAPI.controller;

import com.mobile.SpringMobileAPI.entity.Client;
import com.mobile.SpringMobileAPI.entity.User;
import com.mobile.SpringMobileAPI.repository.UserRepository;
import com.mobile.SpringMobileAPI.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/mobile")
public class UserController {
    private UserService userService;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    Add one Client
    @PostMapping(path = "/users")
    public @ResponseBody String addOneUser(@RequestBody User user){
        userService.addOneUser(user);
        return "New client Added.";
    }

//    Get all clients list
    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public Optional<User> getOneUser(@PathVariable int id){
        return userService.getOneUser(id);
    }

    @PutMapping(path = "/users/{id}")
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
