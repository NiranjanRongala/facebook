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

    @GetMapping("/listofusers")
    public List<User> getAll1() throws InvalidNameFormatException {
        return usersService.getUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User users) throws InvalidNameFormatException {
        return usersService.addUser(users);
    }

    @DeleteMapping("/removeUser/{user_id}")
    public String removeUser(@PathVariable("user_id") int user_id) throws InvalidNameFormatException {
        usersService.removeUser(user_id);
        return "deleted successfully";
    }

    @PutMapping("/userid/{user_id}/username/{username}")
    public User updateUserName(@PathVariable("user_id") int user_id, @RequestParam("username") String user_name) throws InvalidNameFormatException {
        return usersService.updateUserName(user_id, user_name);
    }

    @GetMapping("/ListUserPage/{offset}/limit/{limit}")
    public Page<User> getUserPage(@PathVariable("offset") int a, @PathVariable("limit") int b) throws InvalidNameFormatException {
        return usersService.getuserPage(a, b);
    }

    @GetMapping("/ListUserPages/{offset}/limit/{limit}/sortby/{sortby}")
    public Page<User> getUsersortedPage(@PathVariable("offset") int a, @PathVariable("limit") int b, @PathVariable("sortby") String c) throws InvalidNameFormatException {
        return usersService.getuserPagebySort(a, b, c);
    }
}
