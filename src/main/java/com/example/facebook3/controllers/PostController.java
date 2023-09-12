package com.example.facebook3.controllers;

import com.example.facebook3.Services.PostService;
import com.example.facebook3.entities.Post;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postsService;

    @GetMapping("/posts")
    public List<Post> getPosts() throws InvalidNameFormatException {
        return postsService.getPosts();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post posts) throws InvalidNameFormatException {
        return postsService.addPost(posts);
    }

    @PutMapping("/post-id/{post-id}/post/{post}")
    public Post updatePost(@PathVariable("post-id") int post_id, @PathVariable("post") String post) throws InvalidNameFormatException {

        return postsService.updatePost(post_id, post);

    }

    @DeleteMapping("/post/{post-id}")
    public void removePost(@PathVariable("post-id") int post_id) throws InvalidNameFormatException {
        postsService.removePost(post_id);
    }

    @GetMapping("/posts-for-particular-user/{user-id}")
    public List<Post> getpostsforparticularuser(@PathVariable("user-id") int userid) throws InvalidNameFormatException {
        return postsService.getPostParticularUser(userid);
    }

    @GetMapping("/feed/{followee-id}")
    public List<String> getfeed(@PathVariable("followee-id") int id) throws InvalidNameFormatException {
        return postsService.getfeed(id);
    }
}
