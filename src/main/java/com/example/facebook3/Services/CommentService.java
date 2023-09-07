package com.example.facebook3.Services;

import com.example.facebook3.entities.Comment;
import com.example.facebook3.exceptions.InvalidNameFormatException;

import java.util.List;

public interface CommentService {
    List<Comment> getComments() throws InvalidNameFormatException;

    Comment addComment(Comment comments);

    Comment updateComment(int comment_id, String comment) throws InvalidNameFormatException;

    void removeComment(int comment_id) throws InvalidNameFormatException;

    List<Comment> getCommentsForParticularPost(int postid) throws InvalidNameFormatException;
}
