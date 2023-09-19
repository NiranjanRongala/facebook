package com.example.facebook3.controllers;

import com.example.facebook3.Services.LikeService;
import com.example.facebook3.entities.Like;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    private LikeService likesService;

    @GetMapping("/likes")
    public List<Like> getLikes() throws InvalidNameFormatException {
        return likesService.getLikes();
    }

    @PostMapping("/like")
    public Like addLikes(@RequestBody Like likes) {
        return likesService.addLike(likes);
    }

    @PutMapping("/like-id/{like-id}/post-id/{post-id}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public Like updatelike(@PathVariable("like-id") int likeid, @PathVariable("post-id") int postid) throws InvalidNameFormatException {
        return likesService.updateLike(likeid, postid);
    }

    @DeleteMapping("/like/{like-id}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public void deletelike(@PathVariable("like-id") int likeid) throws InvalidNameFormatException {
        likesService.removelike(likeid);
    }

    @GetMapping("likes-for-particular-post/{post-id}")
    public List<Like> getLikesforsinglePost(@PathVariable("post-id") int postId) throws InvalidNameFormatException {
        return likesService.getLikesForParticularPost(postId);

    }
}
