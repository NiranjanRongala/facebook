package com.example.facebook3.Services;

import com.example.facebook3.entities.Like;
import com.example.facebook3.exceptions.InvalidNameFormatException;

import java.util.List;

public interface LikeService {
    List<Like> getLikes() throws InvalidNameFormatException;

    Like addLike(Like likes);

    Like updateLike(int like_id, int post_id) throws InvalidNameFormatException;

    void removeLike(int like_id) throws InvalidNameFormatException;

    List<Like> getLikesForParticularPost(int postid) throws InvalidNameFormatException;

}
