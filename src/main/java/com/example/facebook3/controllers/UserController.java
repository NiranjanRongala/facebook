package com.example.facebook3.controllers;

import com.example.facebook3.ServicesImp.JwtService;
import com.example.facebook3.ServicesImp.UserServiceImp;
import com.example.facebook3.entities.AuthRequest;
import com.example.facebook3.entities.User;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired

    private JwtService jwtService;
    @Autowired
    private UserServiceImp usersService;
    @Autowired
    private AuthenticationManager authenticationManager;
//
//    @GetMapping("/test1")
//    public String test1(){
//        return "Hello Everyone...";
//    }
//
//    @GetMapping("/test2")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String test2(){
//        return "How are you...";
//    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws UsernameNotFoundException {
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(authRequest.getUsername());
        else
            throw new UsernameNotFoundException("Invalid username");
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public List<User> getUsers() throws InvalidNameFormatException {
        return usersService.getUsers();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User users) throws InvalidNameFormatException {
        return usersService.addUser(users);
    }

    @DeleteMapping("/user/{user-id}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public String removeUser(@PathVariable("user-id") int user_id) throws InvalidNameFormatException {
        usersService.removeUser(user_id);
        return "deleted successfully";
    }

    @PutMapping("/user-id/{user-id}/user-name/{user-name}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public User updateUserName(@PathVariable("user-id") int user_id, @RequestParam("user-name") String user_name) throws InvalidNameFormatException {
        return usersService.updateUserName(user_id, user_name);
    }

    @GetMapping("/userPages/{offset}/limit/{limit}")
    public Page<User> getUserPage(@PathVariable("offset") int a, @PathVariable("limit") int b) throws InvalidNameFormatException {
        return usersService.getUserPage(a, b);
    }

    @GetMapping("/userPages/{offset}/limit/{limit}/sortby/{sortby}")
    public Page<User> getUserSortedPage(@PathVariable("offset") int a, @PathVariable("limit") int b, @PathVariable("sortby") String c) throws InvalidNameFormatException {
        return usersService.getUserPageBySort(a, b, c);
    }


    @PutMapping("/user-id/{user-id}/password/{password}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public User updatePassword(@PathVariable("user-id") int user_id, @RequestParam("password") String password) throws InvalidNameFormatException {
        return usersService.updateUserPassword(user_id,password);
    }

    @PutMapping("/user-id/{user-id}/role/{role}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public User updateRole(@PathVariable("user-id") int user_id, @PathVariable("role") String role) throws InvalidNameFormatException {
        return usersService.updateRole(user_id,role);
    }
}
