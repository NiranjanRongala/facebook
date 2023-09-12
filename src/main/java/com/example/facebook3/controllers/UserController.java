package com.example.facebook3.controllers;

import com.example.facebook3.Services.UserService;
import com.example.facebook3.entities.User;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService usersService;

    @GetMapping("/users")
    public List<User> getAll1() throws InvalidNameFormatException {
        return usersService.getUsers();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User users) throws InvalidNameFormatException {
        return usersService.addUser(users);
    }

    @DeleteMapping("/user/{user-id}")
    public String removeUser(@PathVariable("user-id") int user_id) throws InvalidNameFormatException {
        usersService.removeUser(user_id);
        return "deleted successfully";
    }

    @PutMapping("/user-id/{user-id}/user-name/{user-name}")
    public User updateUserName(@PathVariable("user-id") int user_id, @RequestParam("user-name") String user_name) throws InvalidNameFormatException {
        return usersService.updateUserName(user_id, user_name);
    }

    @GetMapping("/userPages/{offset}/limit/{limit}")
    public Page<User> getUserPage(@PathVariable("offset") int a, @PathVariable("limit") int b) throws InvalidNameFormatException {
        return usersService.getuserPage(a, b);
    }

    @GetMapping("/userPages/{offset}/limit/{limit}/sortby/{sortby}")
    public Page<User> getUsersortedPage(@PathVariable("offset") int a, @PathVariable("limit") int b, @PathVariable("sortby") String c) throws InvalidNameFormatException {
        return usersService.getuserPagebySort(a, b, c);
    }
}
