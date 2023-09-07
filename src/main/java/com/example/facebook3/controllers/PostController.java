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

    @GetMapping("/getPost")
    public List<Post> getPosts() throws InvalidNameFormatException {
        return postsService.getPosts();
    }

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post posts) throws InvalidNameFormatException {
        return postsService.addPost(posts);
    }

    @PutMapping("/post/{postid}/{post}")
    public Post updatePost(@PathVariable("postid") int post_id, @PathVariable("post") String post) throws InvalidNameFormatException {

        return postsService.updatePost(post_id, post);

    }

    @DeleteMapping("/removePost/{postid}")
    public void removePost(@PathVariable("postid") int post_id) throws InvalidNameFormatException {
        postsService.removePost(post_id);
    }

    @GetMapping("/ListPostforParticularUser/{userid}")
    public List<Post> getpostsforparticularuser(@PathVariable("userid") int userid) throws InvalidNameFormatException {
        return postsService.getPostParticularUser(userid);
    }

    @GetMapping("/Listfeed/{followee_id}")
    public List<String> getfeed(@PathVariable("followee_id") int id) throws InvalidNameFormatException {
        return postsService.getfeed(id);
    }
}
