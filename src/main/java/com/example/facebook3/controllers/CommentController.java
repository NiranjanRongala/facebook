package com.example.facebook3.controllers;

import com.example.facebook3.Services.CommentService;
import com.example.facebook3.entities.Comment;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentsService;

    @GetMapping("/comments")
    public List<Comment> getComment() throws InvalidNameFormatException {
        return commentsService.getComments();
    }

    @PostMapping("/comment")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public Comment addcomment(@RequestBody Comment comments) {
        return commentsService.addComment(comments);

    }

    @PutMapping("/comment-id/{comment-id}/comment/{comment}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public Comment updateComment(@PathVariable("comment-id") int commentid, @PathVariable("comment") String comment) throws InvalidNameFormatException {
        return commentsService.updateComment(commentid, comment);
    }

    @DeleteMapping("/comment/{comment-id}")
    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    public void deletecomment(@PathVariable("comment-id") int commentid) throws InvalidNameFormatException {
        commentsService.removeComment(commentid);
    }

    @GetMapping("/comments-for-particular-post/{post-id}")
    List<Comment> getcomments(@PathVariable("post-id") int id) throws InvalidNameFormatException {
        return commentsService.getCommentsForParticularPost(id);
    }

}