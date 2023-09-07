package com.example.facebook3.controllers;

import com.example.facebook3.Services.CommentService;
import com.example.facebook3.entities.Comment;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentsService;

    @GetMapping("/Listofcomment")
    public List<Comment> getComment() throws InvalidNameFormatException {
        return commentsService.getComments();
    }

    @PostMapping("/addcomment")
    public Comment addcomment(@RequestBody Comment comments) {
        return commentsService.addComment(comments);

    }

    @PutMapping("/comment/{commentid}/comment/{comment}")
    public Comment updateComment(@PathVariable("commentid") int commentid, @PathVariable("comment") String comment) throws InvalidNameFormatException {
        return commentsService.updateComment(commentid, comment);
    }

    @DeleteMapping("/removeComment/{commentid}")
    public void deletecomment(@PathVariable("commentid") int commentid) throws InvalidNameFormatException {
        commentsService.removeComment(commentid);
    }

    @GetMapping("/ListCommentsforParticularPost/{postid}")
    List<Comment> getcomments(@PathVariable("postid") int id) throws InvalidNameFormatException {
        return commentsService.getCommentsForParticularPost(id);
    }

}