package com.example.facebook3.Services;

import com.example.facebook3.entities.Follower;
import com.example.facebook3.exceptions.InvalidNameFormatException;

import java.util.List;

public interface FollowerService {
    List<Follower> getFollowers() throws InvalidNameFormatException;

    Follower addFollower(Follower followers);

    Follower updateFollower(int s_no, int user_id) throws InvalidNameFormatException;

    void removeFollower(int s_no) throws InvalidNameFormatException;

    List<Follower> getFollowersforParticularUser(int id) throws InvalidNameFormatException;


}
