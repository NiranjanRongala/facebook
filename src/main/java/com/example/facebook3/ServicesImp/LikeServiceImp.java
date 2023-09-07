package com.example.facebook3.ServicesImp;

import com.example.facebook3.Services.LikeService;
import com.example.facebook3.entities.Like;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImp implements LikeService {
    @Autowired
    private LikeRepo likesRepo;

    @Override
    public List<Like> getLikes() throws InvalidNameFormatException {
        if (likesRepo.findAll().isEmpty())
            throw new InvalidNameFormatException("there is no data ");

        return likesRepo.findAll();
    }

    @Override
    public Like addLike(Like likes) {
        Like likes1 = new Like();
        likes1.setPost_id(likes.getPost_id());
        likes1.setUser_id(likes.getUser_id());
        likes1.setCreated_at(likes.getCreated_at());
        return likesRepo.save(likes1);
    }

    @Override
    public Like updateLike(int like_id, int post_id) throws InvalidNameFormatException {
        Optional<Like> likes = likesRepo.findById(like_id);
        if (likes.isEmpty())
            throw new InvalidNameFormatException("likeid is not found");
        Like likes1 = likes.get();
        likes1.setPost_id(post_id);
        return likesRepo.save(likes1);
    }

    @Override
    public void removelike(int like_id) throws InvalidNameFormatException {
        Optional<Like> likes = likesRepo.findById(like_id);
        if (likes.isEmpty())
            throw new InvalidNameFormatException("likeid is not found");
        likesRepo.deleteById(like_id);

    }

    @Override
    public List<Like> getLikesForParticularPost(int postid) throws InvalidNameFormatException {
        List<Like> likes = likesRepo.getLikes(postid);
        if (likes.isEmpty())
            throw new InvalidNameFormatException("there is no likes for this post");
        return likes;
    }
}
