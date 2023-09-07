package com.example.facebook3.controllers;

import com.example.facebook3.Services.LikeService;
import com.example.facebook3.entities.Like;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    private LikeService likesService;

    @GetMapping("/ListofLikes")
    public List<Like> getLikes() throws InvalidNameFormatException {
        return likesService.getLikes();
    }

    @PostMapping("/addlike")
    public Like addLikes(@RequestBody Like likes) {
        return likesService.addLike(likes);
    }

    @PutMapping("/Like/{likeid}/postid/{postid}")
    public Like updatelike(@PathVariable("likeid") int likeid, @PathVariable("postid") int postid) throws InvalidNameFormatException {
        return likesService.updateLike(likeid, postid);
    }

    @DeleteMapping("/removeLike/{likeid}")
    public void deletelike(@PathVariable("likeid") int likeid) throws InvalidNameFormatException {
        likesService.removelike(likeid);
    }

    @GetMapping("ListLikesForParticularPost/{postid}")
    public List<Like> getLikesforsinglePost(@PathVariable("postid") int postId) throws InvalidNameFormatException {
        return likesService.getLikesForParticularPost(postId);

    }
}
