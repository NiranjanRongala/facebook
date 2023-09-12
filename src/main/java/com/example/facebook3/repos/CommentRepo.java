package com.example.facebook3.repos;

import com.example.facebook3.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment c WHERE c.postid=:postId ")
    List<Comment> getComments(@Param("postId") int postid);
}
