package com.example.facebook3.controllers;

import com.example.facebook3.Services.FollowerService;
import com.example.facebook3.entities.Follower;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowerController {

    @Autowired
    private FollowerService followersService;

    @GetMapping("/ListFollowers")
    public List<Follower> getUsers() throws InvalidNameFormatException {
        return followersService.getFollowers();

    }

    @PostMapping("/addFollower")
    public Follower addFollower(@RequestBody Follower followers) {
        return followersService.addFollower(followers);
    }

    @PutMapping("/Follower/{s_no}/userid/{userid}")
    public Follower updateFollower(@PathVariable("s_no") int s_no, @PathVariable("userid") int userid) throws InvalidNameFormatException {
        return followersService.updateFollower(s_no, userid);
    }

    @DeleteMapping("/removeFollower/{s_no}")
    public void deletefollower(@PathVariable("s_no") int s_no) throws InvalidNameFormatException {
        followersService.removeFollower(s_no);
    }

    @GetMapping("/listof_followers_particular_user/{userid}")
    public List<Follower> get(@PathVariable("userid") int userid) throws InvalidNameFormatException {
        return followersService.getFollowersforParticularUser(userid);
    }


}
