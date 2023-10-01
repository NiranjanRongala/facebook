package com.example.facebook3.ServicesImp;

import com.example.facebook3.Services.FollowerService;
import com.example.facebook3.entities.Follower;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.FollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImp implements FollowerService {
    @Autowired
    private FollowerRepo followersRepo;


    @Override
    public List<Follower> getFollowers() throws InvalidNameFormatException {
        List<Follower> followers = followersRepo.findAll();
        if (followers.isEmpty())
            throw new InvalidNameFormatException("there is no data in Folloers");
        return followersRepo.findAll();
    }


    @Override
    public Follower addFollower(Follower followers) {
        Follower followers1 = new Follower();
        followers1.setFolloweeId(followers.getFolloweeId());
        followers1.setFollowerId(followers.getFollowerId());
        followers1.setCreatedAt(followers.getCreatedAt());
        followers1.setUpdatedAt(followers.getUpdatedAt());
        return followersRepo.save(followers1);
    }

    @Override
    public Follower updateFollower(int s_no, int user_id) throws InvalidNameFormatException {
        Optional<Follower> followers = followersRepo.findById(s_no);
        if (followers.isEmpty())
            throw new InvalidNameFormatException("id is not found");
        Follower followers1 = followers.get();
        followers1.setFollowerId(user_id);
        return followersRepo.save(followers1);
    }

    @Override
    public void removeFollower(int s_no) throws InvalidNameFormatException {

        Optional<Follower> followers = followersRepo.findById(s_no);
        if (followers.isEmpty())
            throw new InvalidNameFormatException("id is not found");
        followersRepo.deleteById(s_no);

    }

    @Override
    public List<Follower> getFollowersForParticularUser(int id) throws InvalidNameFormatException {
        List<Follower> followers = followersRepo.getFollowers(id);
        if (followers.isEmpty())
            throw new InvalidNameFormatException("there is no followers for followee");
        return followers;
    }


}
