package com.example.facebook3.Services;

import com.example.facebook3.entities.Post;
import com.example.facebook3.exceptions.InvalidNameFormatException;

import java.util.List;

public interface PostService {
    List<Post> getPosts() throws InvalidNameFormatException;

    Post addPost(Post posts) throws InvalidNameFormatException;

    Post updatePost(int post_id, String post) throws InvalidNameFormatException;

    void removePost(int post_id) throws InvalidNameFormatException;

    List<Post> getPostParticularUser(int userId) throws InvalidNameFormatException;


    List<String> getFeed(int userid) throws InvalidNameFormatException;
}
