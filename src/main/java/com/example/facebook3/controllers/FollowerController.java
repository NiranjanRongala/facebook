package com.example.facebook3.controllers;

import com.example.facebook3.Services.FollowerService;
import com.example.facebook3.entities.Follower;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowerController {

    @Autowired
    private FollowerService followersService;

    @GetMapping("/followers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Follower> getUsers() throws InvalidNameFormatException {
        return followersService.getFollowers();

    }

    @PostMapping("/follower")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public Follower addFollower(@RequestBody Follower followers) {
        return followersService.addFollower(followers);
    }

    @PutMapping("/follower/{s-no}/followee-id/{followee-id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Follower updateFollower(@PathVariable("s-no") int s_no, @PathVariable("followee-id") int userid) throws InvalidNameFormatException {
        return followersService.updateFollower(s_no, userid);
    }

    @DeleteMapping("/follower/{s-no}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deletefollower(@PathVariable("s-no") int s_no) throws InvalidNameFormatException {
        followersService.removeFollower(s_no);
    }

    @GetMapping("/followers-for-particular-followee/{followee-id}")
    public List<Follower> getFollowers(@PathVariable("followee-id") int userid) throws InvalidNameFormatException {
        return followersService.getFollowersForParticularUser(userid);
    }


}
