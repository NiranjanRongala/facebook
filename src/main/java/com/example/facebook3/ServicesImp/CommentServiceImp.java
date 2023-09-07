package com.example.facebook3.ServicesImp;

import com.example.facebook3.Services.CommentService;
import com.example.facebook3.entities.Comment;
import com.example.facebook3.exceptions.InvalidNameFormatException;
import com.example.facebook3.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepo commentsRepo;

    @Override
    public List<Comment> getComments() throws InvalidNameFormatException {
        List<Comment> comments = commentsRepo.findAll();
        if (comments.isEmpty())
            throw new InvalidNameFormatException("no comments  ");

        return commentsRepo.findAll();
    }

    @Override
    public Comment addComment(Comment comments) {
        Comment comments1 = new Comment();
        comments1.setPost_id(comments.getPost_id());
        comments1.setUser_id(comments.getUser_id());
        comments1.setComment(comments.getComment());
        comments1.setCreated_at(comments.getCreated_at());
        return commentsRepo.save(comments1);
    }

    @Override
    public Comment updateComment(int comment_id, String comment) throws InvalidNameFormatException {
        Optional<Comment> comments = commentsRepo.findById(comment_id);
        if (comments.isEmpty())
            throw new InvalidNameFormatException("commentid is not found");
        Comment comments1 = comments.get();
        comments1.setComment(comment);
        return commentsRepo.save(comments1);
    }

    @Override
    public void removeComment(int comment_id) throws InvalidNameFormatException {
        Optional<Comment> comments = commentsRepo.findById(comment_id);
        if (comments.isEmpty())
            throw new InvalidNameFormatException("commentid is not found");
        commentsRepo.deleteById(comment_id);

    }

    @Override
    public List<Comment> getCommentsForParticularPost(int postid) throws InvalidNameFormatException {
        List<Comment> comments = commentsRepo.getComments(postid);
        if (comments.isEmpty())
            throw new InvalidNameFormatException("no comments for this post");
        return comments;
    }
}
